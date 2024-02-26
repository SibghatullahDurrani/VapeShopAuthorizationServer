package com.sibghat.vape_shop_authorization_server.repositories;

import com.sibghat.vape_shop_authorization_server.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findUserByUsername(String username);
}
