package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Asset;
import com.enjin.sdk.schemas.shared.mutations.AdvancedSendAsset;
import com.enjin.sdk.schemas.shared.mutations.ApproveEnj;
import com.enjin.sdk.schemas.shared.mutations.ApproveMaxEnj;
import com.enjin.sdk.schemas.shared.mutations.CancelTransaction;
import com.enjin.sdk.schemas.shared.mutations.CompleteTrade;
import com.enjin.sdk.schemas.shared.mutations.CreateTrade;
import com.enjin.sdk.schemas.shared.mutations.MeltAsset;
import com.enjin.sdk.schemas.shared.mutations.Message;
import com.enjin.sdk.schemas.shared.mutations.ResetEnjApproval;
import com.enjin.sdk.schemas.shared.mutations.SendEnj;
import com.enjin.sdk.schemas.shared.mutations.SendAsset;
import com.enjin.sdk.schemas.shared.mutations.SetApprovalForAll;
import com.enjin.sdk.schemas.shared.queries.GetBalances;
import com.enjin.sdk.schemas.shared.queries.GetGasPrices;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
import com.enjin.sdk.schemas.shared.queries.GetProject;
import com.enjin.sdk.schemas.shared.queries.GetRequest;
import com.enjin.sdk.schemas.shared.queries.GetRequests;
import com.enjin.sdk.schemas.shared.queries.GetAsset;
import com.enjin.sdk.schemas.shared.queries.GetAssets;

import java.util.List;

/**
 * Interface for shared schema implementation.
 */
public interface ISharedSchema {

    /**
     * Sends {@link AdvancedSendAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> advancedSendAsset(AdvancedSendAsset request);

    /**
     * Sends {@link AdvancedSendAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void advancedSendAsset(AdvancedSendAsset request,
                           HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ApproveEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> approveEnj(ApproveEnj request);

    /**
     * Sends {@link ApproveEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void approveEnj(ApproveEnj request,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ApproveMaxEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> approveMaxEnj(ApproveMaxEnj request);

    /**
     * Sends {@link ApproveMaxEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void approveMaxEnj(ApproveMaxEnj request,
                       HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link CancelTransaction} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Boolean> cancelTransaction(CancelTransaction request);

    /**
     * Sends {@link CancelTransaction} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void cancelTransaction(CancelTransaction request,
                           HttpCallback<GraphQLResponse<Boolean>> callback);

    /**
     * Sends {@link CompleteTrade} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> completeTrade(CompleteTrade request);

    /**
     * Sends {@link CompleteTrade} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void completeTrade(CompleteTrade request,
                       HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link CreateTrade} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> createTrade(CreateTrade request);

    /**
     * Sends {@link CreateTrade} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void createTrade(CreateTrade request,
                     HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link GetBalances} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Balance>> getBalances(GetBalances request);

    /**
     * Sends {@link GetBalances} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getBalances(GetBalances request,
                     HttpCallback<GraphQLResponse<List<Balance>>> callback);

    /**
     * Sends {@link GetGasPrices} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request);

    /**
     * Sends {@link GetGasPrices} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getGasPrices(GetGasPrices request,
                      HttpCallback<GraphQLResponse<GasPrices>> callback);

    /**
     * Sends {@link GetPlatform} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Platform> getPlatform(GetPlatform request);

    /**
     * Sends {@link GetPlatform} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getPlatform(GetPlatform request,
                     HttpCallback<GraphQLResponse<Platform>> callback);

    /**
     * Sends {@link GetProject} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Project> getProject(GetProject request);

    /**
     * Sends {@link GetProject} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getProject(GetProject request,
                    HttpCallback<GraphQLResponse<Project>> callback);

    /**
     * Sends {@link GetRequest} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> getRequest(GetRequest request);

    /**
     * Sends {@link GetRequest} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getRequest(GetRequest request,
                    HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link GetRequests} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Request>> getRequests(GetRequests request);

    /**
     * Sends {@link GetRequests} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getRequests(GetRequests request,
                     HttpCallback<GraphQLResponse<List<Request>>> callback);

    /**
     * Sends {@link GetAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Asset> getAsset(GetAsset request);

    /**
     * Sends {@link GetAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getAsset(GetAsset request,
                  HttpCallback<GraphQLResponse<Asset>> callback);

    /**
     * Sends {@link GetAssets} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<List<Asset>> getAssets(GetAssets request);

    /**
     * Sends {@link GetAssets} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void getAssets(GetAssets request,
                   HttpCallback<GraphQLResponse<List<Asset>>> callback);

    /**
     * Sends {@link MeltAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> meltAsset(MeltAsset request);

    /**
     * Sends {@link MeltAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void meltAsset(MeltAsset request,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link Message} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> message(Message request);

    /**
     * Sends {@link Message} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void message(Message request,
                 HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link ResetEnjApproval} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> resetEnjApproval(ResetEnjApproval request);

    /**
     * Sends {@link ResetEnjApproval} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void resetEnjApproval(ResetEnjApproval request,
                          HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SendAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> sendAsset(SendAsset request);

    /**
     * Sends {@link SendAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void sendAsset(SendAsset request,
                   HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SendEnj} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> sendEnj(SendEnj request);

    /**
     * Sends {@link SendEnj} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void sendEnj(SendEnj request,
                 HttpCallback<GraphQLResponse<Request>> callback);

    /**
     * Sends {@link SetApprovalForAll} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     */
    GraphQLResponse<Request> setApprovalForAll(SetApprovalForAll request);

    /**
     * Sends {@link SetApprovalForAll} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    void setApprovalForAll(SetApprovalForAll request,
                           HttpCallback<GraphQLResponse<Request>> callback);

}
