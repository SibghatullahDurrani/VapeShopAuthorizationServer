package com.sibghat.vape_shop_authorization_server.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "redirect_uris")
public class RedirectUri {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "redirect_uris_generator")
    @SequenceGenerator(name = "redirect_uris_generator", sequenceName = "redirect_uris_seq",allocationSize = 1)
    private Long id;

    private String redirectUri;

    @ManyToOne
    @JoinColumn(
            name = "client_id",
            nullable = false
    )
    private Client client;

}
