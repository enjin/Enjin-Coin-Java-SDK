package com.enjin.sdk.serialization.converter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import com.enjin.sdk.graphql.GraphQLError;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.PaginationCursor;
import com.enjin.sdk.serialization.BigIntegerDeserializer;
import com.enjin.sdk.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.java.Log;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Body for GraphQL requests and responses, closed for modification but open for extension.
 */
@Log
public class GraphConverter extends Converter.Factory {

    private static final String DATA_KEY = "data";
    private static final String ERRORS_KEY = "errors";
    private static final String RESULT_KEY = "result";
    private static final String ITEM_KEY = "items";
    private static final String CURSOR_KEY = "cursor";

    private static final String RESULT_PATH = DATA_KEY + '.' + RESULT_KEY;
    private static final String CURSOR_PATH = RESULT_PATH + '.' + CURSOR_KEY;

    /**
     * Protected parser to make use of the default parse settings.
     */
    protected final JsonParser parser = new JsonParser();

    /**
     * Protected gson builder to make use of custom builder settings for deserialization.
     */
    protected final Gson fromJson = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .setLenient()
            .serializeNulls()
            .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer())
            .create();

    /**
     * Protected constructor because we want to make use of the Factory Pattern to create our converter.
     */
    protected GraphConverter() {
    }

    /**
     * HttpResponse body converter delegates logic processing to a child class that handles wrapping and deserialization
     * of the json response results.
     *
     * @param annotations all the annotation applied to the requesting Call method
     * @param retrofit the retrofit object representing the response
     * @param type the generic type declared on the Call method
     *
     * @see GraphResponseConverter
     * @see retrofit2.Call
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (rawType == GraphQLResponse.class) {
                return new GraphResponseConverter<>(parameterizedType);
            }
        }

        return null;
    }

    /**
     * Returns a new graph converter.
     *
     * @return the created graph converter
     */
    public static GraphConverter create() {
        return new GraphConverter();
    }

    /**
     * GraphQL response body converter to unwrap nested object results, resulting in a smaller generic tree for
     * requests.
     */
    protected class GraphResponseConverter<T> implements Converter<ResponseBody, GraphQLResponse<T>> {
        protected ParameterizedType graphResponseType;
        protected Type resultType;

        /**
         * Sole constructor.
         *
         * @param graphResponseType the graph response type
         */
        protected GraphResponseConverter(ParameterizedType graphResponseType) {
            this.graphResponseType = graphResponseType;
            this.resultType = graphResponseType.getActualTypeArguments()[0];
        }

        /**
         * Converter contains logic on how to handle responses, since GraphQL responses follow the JsonAPI spec it makes
         * sense to wrap our base query response results and errors response in here, the logic remains open to the
         * implementation.
         *
         * @param responseBody the retrofit response body received from the network
         * @return the type declared in the Call of the request
         */
        @Override
        public GraphQLResponse<T> convert(ResponseBody responseBody) {
            String raw = null;
            T result = null;
            List<GraphQLError> errors = null;
            PaginationCursor cursor = null;

            try {
                raw = responseBody.string();

                JsonElement elem = parser.parse(raw);
                if (elem.isJsonObject()) {
                    JsonObject root = elem.getAsJsonObject();
                    result = getResult(root);
                    errors = getErrors(root);
                    cursor = getCursor(root);
                }
            } catch (IOException e) {
                GraphConverter.log.log(Level.SEVERE, "An exception occurred:", e);
            }

            return new GraphQLResponse<>(raw, result, errors, cursor);
        }

        private T getResult(JsonObject root) {
            Optional<JsonElement> optional = GsonUtil.getJsonElement(root, RESULT_PATH);

            if (GsonUtil.isJsonObject(optional)) {
                JsonObject result = optional.get().getAsJsonObject();

                if (result.has(ITEM_KEY) && result.has(CURSOR_KEY))
                    return fromJson.fromJson(result.get(ITEM_KEY), resultType);

                return fromJson.fromJson(result, resultType);
            } else if (GsonUtil.isJsonArray(optional)) {
                return fromJson.fromJson(optional.get(), resultType);
            }

            return null;
        }

        private List<GraphQLError> getErrors(JsonObject root) {
            List<GraphQLError> errors = null;

            if (root.has(ERRORS_KEY)) {
                errors = fromJson.fromJson(root.get(ERRORS_KEY),
                                         TypeToken.getParameterized(ArrayList.class, GraphQLError.class).getType());
            }

            return errors;
        }

        private PaginationCursor getCursor(JsonObject root) {
            Optional<JsonElement> optional = GsonUtil.getJsonElement(root, CURSOR_PATH);

            if (!optional.isPresent())
                return null;

            return fromJson.fromJson(optional.get(), PaginationCursor.class);
        }
    }

}