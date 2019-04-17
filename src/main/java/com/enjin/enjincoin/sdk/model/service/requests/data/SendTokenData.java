package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class SendTokenData {

    @SerializedName("token_id")
    private String tokenId;

    @SerializedName("token_index")
    private String tokenIndex;

    @SerializedName("recipient_address")
    private String recipientAddress;

    @SerializedName("recipient_identity_id")
    private Integer recipientIdentityId;

    private Integer value;

}
