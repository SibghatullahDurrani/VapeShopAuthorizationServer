package com.sibghat.vape_shop_authorization_server.services.user;

import com.sibghat.vape_shop_authorization_server.dtos.SecurityUserDto;

public interface IUserServices {
    SecurityUserDto findUserByUsername(String username);
}
