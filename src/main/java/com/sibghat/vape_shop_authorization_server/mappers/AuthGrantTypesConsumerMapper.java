package com.sibghat.vape_shop_authorization_server.mappers;

import com.sibghat.vape_shop_authorization_server.domains.GrantType;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.Set;
import java.util.function.Consumer;

public class AuthGrantTypesConsumerMapper implements ConsumerMapper<Set<AuthorizationGrantType>> {

    private final Set<GrantType> grantTypes;

    public AuthGrantTypesConsumerMapper(Set<GrantType> grantTypes) {
        this.grantTypes = grantTypes;
    }

    @Override
    public void addToSet(Set<AuthorizationGrantType> setToAppend) {
        for(GrantType grantType : grantTypes){
            setToAppend.add(new AuthorizationGrantType(grantType.getGrantType()));
        }
    }

    @Override
    public Consumer<Set<AuthorizationGrantType>> map() {
        return this::addToSet;
    }
}
