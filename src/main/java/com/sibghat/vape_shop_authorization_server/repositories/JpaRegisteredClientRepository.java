package com.sibghat.vape_shop_authorization_server.repositories;

import com.sibghat.vape_shop_authorization_server.domains.CustomRegisteredClient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaRegisteredClientRepository implements RegisteredClientRepository {

    private final CustomRegisteredClientRepository customRegisteredClientRepository;

    public JpaRegisteredClientRepository(CustomRegisteredClientRepository customRegisteredClientRepository) {
        this.customRegisteredClientRepository = customRegisteredClientRepository;
    }

    @Override
    public void save(RegisteredClient registeredClient) {
        CustomRegisteredClient customRegisteredClient = CustomRegisteredClient.builder()
                .id(registeredClient.getId())
                .clientId(registeredClient.getClientId())
                .clientSecret(registeredClient.getClientSecret())
                .build();
        customRegisteredClientRepository.save(customRegisteredClient);
    }

    @Override
    public RegisteredClient findById(String id) {
        Optional<CustomRegisteredClient> customRegisteredClient = customRegisteredClientRepository.findById(id);
        return customRegisteredClient.map(registeredClient -> RegisteredClient.withId(registeredClient.getId())
                .clientId(registeredClient.getClientId())
                .clientSecret(registeredClient.getClientSecret())
                .scope(OidcScopes.OPENID)
                .redirectUri("https://springone.io/authorized")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .build())
                .orElseThrow(() -> new EntityNotFoundException("client not registered"));
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Optional<CustomRegisteredClient> customRegisteredClient = customRegisteredClientRepository.findByClientId(clientId);
        return customRegisteredClient.map(registeredClient -> RegisteredClient.withId(registeredClient.getId())
                .clientId(registeredClient.getClientId())
                .clientSecret(registeredClient.getClientSecret())
                .scope(OidcScopes.OPENID)
                .redirectUri("https://springone.io/authorized")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .build())
                .orElseThrow(() -> new EntityNotFoundException("client not registered"));
    }
}
