package com.sibghat.vape_shop_authorization_server.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "registered_clients")
public class Client {

    @Id
    private String id;

    @NotBlank
    private String clientId;

    @NotBlank
    private String clientSecret;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "clients_scopes",
            joinColumns = {
                    @JoinColumn(
                            name = "client_id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "scope_id",
                            nullable = false
                    )
            }
    )
    private Set<Scope> scopes;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "clients_authentication_methods",
            joinColumns = {
                    @JoinColumn(
                            name = "client_id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "authentication_method_id",
                            nullable = false
                    )
            }
    )
    private Set<AuthenticationMethod> authenticationMethods;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "clients_grant_types",
            joinColumns = {
                    @JoinColumn(
                            name = "client_id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "grant_type_id",
                            nullable = false
                    )
            }
    )
    private Set<GrantType> grantTypes;

    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<RedirectUri> redirectUris;

}
