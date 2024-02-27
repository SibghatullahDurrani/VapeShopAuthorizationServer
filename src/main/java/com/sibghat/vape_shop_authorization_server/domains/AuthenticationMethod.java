package com.sibghat.vape_shop_authorization_server.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authentication_methods")
public class AuthenticationMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_method_generator")
    @SequenceGenerator(name = "auth_method_generator", sequenceName = "auth_method_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Column(
            nullable = false
    )
    private String authenticationMethod;

}
