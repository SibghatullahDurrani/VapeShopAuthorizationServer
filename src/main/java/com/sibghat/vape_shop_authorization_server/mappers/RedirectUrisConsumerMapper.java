package com.sibghat.vape_shop_authorization_server.mappers;

import com.sibghat.vape_shop_authorization_server.domains.RedirectUri;

import java.util.Set;
import java.util.function.Consumer;

public class RedirectUrisConsumerMapper implements ConsumerMapper<Set<String>>{

    private final Set<RedirectUri> redirectUris;

    public RedirectUrisConsumerMapper(Set<RedirectUri> redirectUris) {
        this.redirectUris = redirectUris;
    }

    @Override
    public void addToSet(Set<String> setToAppend) {
        for(RedirectUri redirectUri : this.redirectUris){
            setToAppend.add(redirectUri.getRedirectUri());
        }
    }

    @Override
    public Consumer<Set<String>> map() {
        return this::addToSet;
    }
}
