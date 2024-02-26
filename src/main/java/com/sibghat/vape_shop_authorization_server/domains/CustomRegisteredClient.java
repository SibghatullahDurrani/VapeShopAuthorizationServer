package com.sibghat.vape_shop_authorization_server.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "registered_clients")
public class CustomRegisteredClient {

    @Id
    private String id;

    @NotBlank
    private String clientId;

    @NotBlank
    private String clientSecret;

}
