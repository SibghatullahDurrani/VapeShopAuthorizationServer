package com.sibghat.vape_shop_authorization_server.mappers;

import com.sibghat.vape_shop_authorization_server.domains.User;
import com.sibghat.vape_shop_authorization_server.dtos.SecurityUserDto;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserMapper implements IMapper<User, SecurityUserDto> {
    @Override
    public SecurityUserDto mapFrom(User user) {
        return SecurityUserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .enabled(user.isEnabled())
                .build();
    }
}
