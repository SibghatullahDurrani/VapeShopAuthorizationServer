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
@Table(name = "scopes")
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scopes_generator")
    @SequenceGenerator(name = "scopes_generator", sequenceName = "scopes_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Column(
            nullable = false
    )
    private String scope;

}
