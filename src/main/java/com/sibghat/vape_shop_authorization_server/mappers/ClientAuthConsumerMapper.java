package com.sibghat.vape_shop_authorization_server.mappers;

import com.sibghat.vape_shop_authorization_server.domains.AuthenticationMethod;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.Set;
import java.util.function.Consumer;

public class ClientAuthConsumerMapper implements ConsumerMapper<Set<ClientAuthenticationMethod>>{

    private final Set<AuthenticationMethod> authenticationMethods;

    public ClientAuthConsumerMapper(Set<AuthenticationMethod> authenticationMethods) {
        this.authenticationMethods = authenticationMethods;
    }

    @Override
    public void addToSet(Set<ClientAuthenticationMethod> setToAppend) {
        for(AuthenticationMethod authenticationMethod : this.authenticationMethods){
            setToAppend.add(new ClientAuthenticationMethod(authenticationMethod.getAuthenticationMethod()));
        }

    }

    @Override
    public Consumer<Set<ClientAuthenticationMethod>> map() {
        return this::addToSet;
    }
}
