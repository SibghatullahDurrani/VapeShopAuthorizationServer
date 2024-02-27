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
@Table(name = "grant_types")
public class GrantType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grant_type_generator")
    @SequenceGenerator(name = "grant_type_generator", sequenceName = "grant_type_seq",allocationSize = 1)
    private Long id;

    @NotBlank
    @Column(
            nullable = false
    )
    private String grantType;

}
