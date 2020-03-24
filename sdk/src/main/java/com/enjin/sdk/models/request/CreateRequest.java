package com.enjin.sdk.models.request;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.request.data.AddLogData;
import com.enjin.sdk.models.request.data.AdvancedSendTokenData;
import com.enjin.sdk.models.request.data.ApproveEnjData;
import com.enjin.sdk.models.request.data.ApproveItemData;
import com.enjin.sdk.models.request.data.BatchApproveData;
import com.enjin.sdk.models.request.data.CompleteTradeData;
import com.enjin.sdk.models.request.data.CreateTokenData;
import com.enjin.sdk.models.request.data.CreateTradeData;
import com.enjin.sdk.models.request.data.DecreaseMaxMeltFeeData;
import com.enjin.sdk.models.request.data.DecreaseMaxTransferFeeData;
import com.enjin.sdk.models.request.data.MeltTokenData;
import com.enjin.sdk.models.request.data.MessageData;
import com.enjin.sdk.models.request.data.MintTokenData;
import com.enjin.sdk.models.request.data.ReleaseReserveData;
import com.enjin.sdk.models.request.data.SendEnjData;
import com.enjin.sdk.models.request.data.SendTokenData;
import com.enjin.sdk.models.request.data.SetApprovalForAllData;
import com.enjin.sdk.models.request.data.SetItemUriData;
import com.enjin.sdk.models.request.data.SetMeltFeeData;
import com.enjin.sdk.models.request.data.SetTransferFeeData;
import com.enjin.sdk.models.request.data.SetTransferableData;
import com.enjin.sdk.models.request.data.SetWhitelistedData;
import com.enjin.sdk.models.request.data.UpdateItemNameData;
import com.enjin.sdk.services.request.RequestsService;

/**
 * A builder for creating a new request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class CreateRequest extends GraphQLRequest<CreateRequest> implements TransactionFragment<CreateRequest> {

    public CreateRequest appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    public CreateRequest ethAddr(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

    /**
     * The id of the identity this request was created for.
     *
     * @param identityId the identity id.
     *
     * @return builder.
     */
    public CreateRequest identityId(int identityId) {
        set("identityId", identityId);
        return this;
    }

    /**
     * The transaction type.
     *
     * @param type the transaction type.
     *
     * @return the builder.
     */
    public CreateRequest transactionType(TransactionType type) {
        set("type", type);
        return this;
    }

    /**
     * Whether to test the request prior to creating it. By default this is set to true.
     * Disabling tests means that gas fees will be lost if a transaction fails on the
     * blockchain. Disable with caution.
     *
     * @return the builder.
     */
    public CreateRequest disableTest() {
        set("test", false);
        return this;
    }

    /**
     * When true a transaction will be tested, but won't be saved or sent. This is handy
     * if you wish test settings without submitting any blockchain transactions.
     *
     * @return the builder.
     */
    public CreateRequest testOnly() {
        set("dummy", true);
        return this;
    }

    /**
     * Sets the create token data.
     *
     * @param createTokenData the data.
     *
     * @return the builder.
     */
    public CreateRequest createToken(CreateTokenData createTokenData) {
        set("create_token_data", createTokenData);
        transactionType(TransactionType.CREATE);
        return this;
    }

    /**
     * Sets the create trade data.
     *
     * @param createTradeData the data.
     *
     * @return the builder.
     */
    public CreateRequest createTrade(CreateTradeData createTradeData) {
        set("create_trade_data", createTradeData);
        transactionType(TransactionType.CREATE_TRADE);
        return this;
    }

    /**
     * Sets the complete trade data.
     *
     * @param completeTradeData the data.
     *
     * @return the builder.
     */
    public CreateRequest completeTrade(CompleteTradeData completeTradeData) {
        set("complete_trade_data", completeTradeData);
        transactionType(TransactionType.COMPLETE_TRADE);
        return this;
    }

    /**
     * Sets the mint data.
     *
     * @param mintTokenData the data.
     *
     * @return the builder.
     */
    public CreateRequest mintToken(MintTokenData mintTokenData) {
        set("mint_token_data", mintTokenData);
        transactionType(TransactionType.MINT);
        return this;
    }

    /**
     * Sets the melt data.
     *
     * @param meltTokenData the data.
     *
     * @return the builder.
     */
    public CreateRequest meltToken(MeltTokenData meltTokenData) {
        set("melt_token_data", meltTokenData);
        transactionType(TransactionType.MELT);
        return this;
    }

    /**
     * Sets the send token data.
     *
     * @param sendTokenData the data.
     *
     * @return the builder.
     */
    public CreateRequest sendToken(SendTokenData sendTokenData) {
        set("send_token_data", sendTokenData);
        transactionType(TransactionType.SEND);
        return this;
    }

    public CreateRequest sendEnj(SendEnjData sendEnjData) {
        set("send_enj_data", sendEnjData);
        transactionType(TransactionType.SEND_ENJ);
        return this;
    }

    /**
     * Sets the advanced send token data.
     *
     * @param advancedSendTokenData the data.
     *
     * @return the builder.
     */
    public CreateRequest advancedSendToken(AdvancedSendTokenData advancedSendTokenData) {
        set("advanced_send_token_data", advancedSendTokenData);
        transactionType(TransactionType.ADVANCED_SEND);
        return this;
    }

    /**
     * Sets the update item name data.
     *
     * @param updateItemNameData the data.
     *
     * @return the builder.
     */
    public CreateRequest updateItemName(UpdateItemNameData updateItemNameData) {
        set("update_item_name_data", updateItemNameData);
        transactionType(TransactionType.UPDATE_NAME);
        return this;
    }

    /**
     * Sets the set item uri data.
     *
     * @param setItemUriData the data.
     *
     * @return the builder.
     */
    public CreateRequest setItemUri(SetItemUriData setItemUriData) {
        set("set_item_uri_data", setItemUriData);
        transactionType(TransactionType.SET_ITEM_URI);
        return this;
    }

    /**
     * Sets the set whitelisted data.
     *
     * @param setWhitelistedData the data.
     *
     * @return the builder.
     */
    public CreateRequest setWhitelisted(SetWhitelistedData setWhitelistedData) {
        set("set_whitelisted_data", setWhitelistedData);
        transactionType(TransactionType.SET_WHITELISTED);
        return this;
    }

    /**
     * Sets the approve enj data.
     *
     * @param approveEnjData the data.
     *
     * @return the builder.
     */
    public CreateRequest approveEnj(ApproveEnjData approveEnjData) {
        set("approve_enj_data", approveEnjData);
        transactionType(TransactionType.APPROVE);
        return this;
    }

    /**
     * Sets the approve item data.
     *
     * @param approveItemData the data.
     *
     * @return the builder.
     */
    public CreateRequest approveItem(ApproveItemData approveItemData) {
        set("approve_item_data", approveItemData);
        transactionType(TransactionType.APPROVE);
        return this;
    }

    /**
     * Sets the set transferable data.
     *
     * @param setTransferableData the data.
     *
     * @return the builder.
     */
    public CreateRequest setTransferable(SetTransferableData setTransferableData) {
        set("set_transferable_data", setTransferableData);
        transactionType(TransactionType.SET_TRANSFERABLE);
        return this;
    }

    /**
     * Sets the set melt fee data.
     *
     * @param setMeltFeeData the data.
     *
     * @return the builder.
     */
    public CreateRequest setMeltFee(SetMeltFeeData setMeltFeeData) {
        set("set_melt_fee_data", setMeltFeeData);
        transactionType(TransactionType.SET_MELT_FEE);
        return this;
    }

    /**
     * Sets the decrease max melt fee data.
     *
     * @param decreaseMaxMeltFeeData the data.
     *
     * @return the builder.
     */
    public CreateRequest decreaseMaxMeltFee(DecreaseMaxMeltFeeData decreaseMaxMeltFeeData) {
        set("decrease_max_melt_fee_data", decreaseMaxMeltFeeData);
        transactionType(TransactionType.DECREASE_MAX_MELT_FEE);
        return this;
    }

    /**
     * Sets the set transfer fee data.
     *
     * @param setTransferFeeData the data.
     *
     * @return the builder.
     */
    public CreateRequest setTransferFee(SetTransferFeeData setTransferFeeData) {
        set("set_transfer_fee_data", setTransferFeeData);
        transactionType(TransactionType.SET_TRANSFER_FEE);
        return this;
    }

    /**
     * Sets the decrease max transfer fee data.
     *
     * @param decreaseMaxTransferFeeData the data.
     *
     * @return the builder.
     */
    public CreateRequest decreaseMaxTransferFee(DecreaseMaxTransferFeeData decreaseMaxTransferFeeData) {
        set("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData);
        transactionType(TransactionType.DECREASE_MAX_TRANSFER_FEE);
        return this;
    }

    public CreateRequest releaseReserve(ReleaseReserveData releaseReserveData) {
        set("release_reserve_data", releaseReserveData);
        transactionType(TransactionType.RELEASE_RESERVE);
        return this;
    }

    /**
     * Sets the add log data.
     *
     * @param addLogData the data.
     *
     * @return the builder.
     */
    public CreateRequest addLog(AddLogData addLogData) {
        set("add_log_data", addLogData);
        transactionType(TransactionType.ADD_LOG);
        return this;
    }

    /**
     * Sets the set approval for all data.
     *
     * @param setApprovalForAllData the data.
     *
     * @return the builder.
     */
    public CreateRequest setApprovalForAll(SetApprovalForAllData setApprovalForAllData) {
        set("set_approval_for_all_data", setApprovalForAllData);
        transactionType(TransactionType.SET_APPROVAL_FOR_ALL);
        return this;
    }

    /**
     * Sets the message data.
     *
     * @param messageData the data.
     *
     * @return the builder.
     */
    public CreateRequest message(MessageData messageData) {
        set("message_data", messageData);
        transactionType(TransactionType.MESSAGE);
        return this;
    }

}
