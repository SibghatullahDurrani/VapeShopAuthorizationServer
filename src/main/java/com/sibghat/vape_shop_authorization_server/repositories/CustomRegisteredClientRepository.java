package com.sibghat.vape_shop_authorization_server.repositories;

import com.sibghat.vape_shop_authorization_server.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomRegisteredClientRepository extends JpaRepository<Client,String> {

    Optional<Client> findByClientId(String clientId);

}
