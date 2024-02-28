package com.sibghat.vape_shop_authorization_server.repositories;

import com.sibghat.vape_shop_authorization_server.domains.Client;
import com.sibghat.vape_shop_authorization_server.mappers.AuthGrantTypesConsumerMapper;
import com.sibghat.vape_shop_authorization_server.mappers.ClientAuthConsumerMapper;
import com.sibghat.vape_shop_authorization_server.mappers.RedirectUrisConsumerMapper;
import com.sibghat.vape_shop_authorization_server.mappers.ScopesConsumerMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;

@Service
public class JpaRegisteredClientRepository implements RegisteredClientRepository {


    private final CustomRegisteredClientRepository customRegisteredClientRepository;

    public JpaRegisteredClientRepository(CustomRegisteredClientRepository customRegisteredClientRepository) {
        this.customRegisteredClientRepository = customRegisteredClientRepository;
    }

    @Override
    public void save(RegisteredClient registeredClient) {
        Client client = Client.builder()
                .id(registeredClient.getId())
                .clientId(registeredClient.getClientId())
                .clientSecret(registeredClient.getClientSecret())
                .build();
        customRegisteredClientRepository.save(client);
    }

    @Override
    public RegisteredClient findById(String id) {
        Optional<Client> customRegisteredClient = customRegisteredClientRepository.findById(id);
        return getRegisteredClient(customRegisteredClient);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Optional<Client> customRegisteredClient = customRegisteredClientRepository.findByClientId(clientId);
        return getRegisteredClient(customRegisteredClient);
    }

    private RegisteredClient getRegisteredClient(Optional<Client> customRegisteredClient) {
        if(customRegisteredClient.isPresent()){
            RegisteredClient.Builder registeredClientBuilder =
                    RegisteredClient.withId(customRegisteredClient.get().getId())
                            .clientId(customRegisteredClient.get().getClientId())
                            .clientSecret(customRegisteredClient.get().getClientSecret());
            ScopesConsumerMapper scopesConsumerMapper =
                    new ScopesConsumerMapper(customRegisteredClient.get().getScopes());
            RedirectUrisConsumerMapper redirectUrisConsumerMapper =
                    new RedirectUrisConsumerMapper(new HashSet<>(customRegisteredClient.get().getRedirectUris()));
            ClientAuthConsumerMapper clientAuthConsumerMapper =
                    new ClientAuthConsumerMapper(customRegisteredClient.get().getAuthenticationMethods());
            AuthGrantTypesConsumerMapper authGrantTypesConsumerMapper =
                    new AuthGrantTypesConsumerMapper(customRegisteredClient.get().getGrantTypes());
            registeredClientBuilder.scopes(scopesConsumerMapper.map());
            registeredClientBuilder.redirectUris(redirectUrisConsumerMapper.map());
            registeredClientBuilder.clientAuthenticationMethods(clientAuthConsumerMapper.map());
            registeredClientBuilder.authorizationGrantTypes(authGrantTypesConsumerMapper.map());
            registeredClientBuilder.tokenSettings(TokenSettings.builder()
                            .accessTokenTimeToLive(Duration.ofHours(24))
                    .build());

            return registeredClientBuilder.build();
        }else{
            throw new EntityNotFoundException("client not registered");
        }
    }
}
