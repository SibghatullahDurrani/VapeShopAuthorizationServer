package com.sibghat.vape_shop_authorization_server.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "redirect_generator")
    @SequenceGenerator(name = "redirect_generator", sequenceName = "redirect_seq", allocationSize = 1)
    private Long id;

    private String redirectUri;

    @ManyToOne
    @JoinColumn(
            name = "client_id"
    )
    @JsonBackReference
    private Client client;

}
