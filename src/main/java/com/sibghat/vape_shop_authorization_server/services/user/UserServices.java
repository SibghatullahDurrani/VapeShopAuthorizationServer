package com.sibghat.vape_shop_authorization_server.services.user;

import com.sibghat.vape_shop_authorization_server.domains.User;
import com.sibghat.vape_shop_authorization_server.dtos.SecurityUserDto;
import com.sibghat.vape_shop_authorization_server.mappers.SecurityUserMapper;
import com.sibghat.vape_shop_authorization_server.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices implements IUserServices{

    private final UserRepository userRepository;
    private final SecurityUserMapper securityUserMapper;

    public UserServices(UserRepository userRepository, SecurityUserMapper securityUserMapper) {
        this.userRepository = userRepository;
        this.securityUserMapper = securityUserMapper;
    }

    @Override
    public SecurityUserDto findUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.map(securityUserMapper::mapFrom)
                .orElseThrow(() -> new UsernameNotFoundException(username + " username not found"));
    }
}
