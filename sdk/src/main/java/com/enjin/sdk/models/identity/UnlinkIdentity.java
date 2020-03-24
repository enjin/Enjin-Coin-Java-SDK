package com.enjin.sdk.models.identity;

import com.enjin.sdk.graphql.GraphQLRequest;

public class UnlinkIdentity extends GraphQLRequest<UnlinkIdentity> implements IdentityFragment<UnlinkIdentity> {

    public UnlinkIdentity id(int userId) {
        set("id", userId);
        return this;
    }

}
