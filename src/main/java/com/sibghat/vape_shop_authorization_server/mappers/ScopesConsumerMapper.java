package com.sibghat.vape_shop_authorization_server.mappers;

import com.sibghat.vape_shop_authorization_server.domains.Scope;

import java.util.Set;
import java.util.function.Consumer;

public class ScopesConsumerMapper implements ConsumerMapper<Set<String>>{

    private final Set<Scope> scopes;

    public ScopesConsumerMapper(Set<Scope> scopes) {
        this.scopes = scopes;
    }

    @Override
    public void addToSet(Set<String> setToAppend){
        for(Scope scope : this.scopes){
            setToAppend.add(scope.getScope());
        }
    }
    @Override
    public Consumer<Set<String>> map() {
        return this::addToSet;
    }
}
