package com.sibghat.vape_shop_authorization_server.repositories;

import com.sibghat.vape_shop_authorization_server.domains.CustomRegisteredClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomRegisteredClientRepository extends JpaRepository<CustomRegisteredClient,String> {

    Optional<CustomRegisteredClient> findByClientId(String clientId);

}
