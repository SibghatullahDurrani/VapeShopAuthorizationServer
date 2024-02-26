package com.sibghat.vape_shop_authorization_server.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecurityUserDto {

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    @NotBlank
    private String role;

    @NotNull
    private Boolean enabled;
}
