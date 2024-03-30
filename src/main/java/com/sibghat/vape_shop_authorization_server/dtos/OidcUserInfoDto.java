package com.sibghat.vape_shop_authorization_server.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class OidcUserInfoDto {

    @NotNull
    private Long id;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String username;

}
