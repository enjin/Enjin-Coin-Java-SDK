package com.enjin.sdk.service.users;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.auth.AuthTokens;
import com.enjin.sdk.model.service.auth.AuthUser;
import com.enjin.sdk.model.service.users.OAuthUser;
import com.enjin.sdk.model.service.users.CreateUser;
import com.enjin.sdk.model.service.users.GetUser;
import com.enjin.sdk.model.service.users.GetUsers;
import com.enjin.sdk.model.service.users.User;

public interface SynchronousUsersService {

    /**
     * Gets users that match the query parameters.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<List<User>>> getUsersSync(GetUsers query);

    HttpResponse<GraphQLResponse<User>> getUserSync(GetUser query);

    /**
     * Creates a new user.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<User>> createUserSync(CreateUser query);

    /**
     * Authenticates a user and returns the users access tokens.
     *
     * @param query the query.
     *
     * @return the response.
     *
     * @throws IOException if a communication error occurred.
     */
    HttpResponse<GraphQLResponse<User>> oAuthUserSync(OAuthUser query);

    HttpResponse<GraphQLResponse<AuthTokens>> authUserSync(AuthUser query);

}
