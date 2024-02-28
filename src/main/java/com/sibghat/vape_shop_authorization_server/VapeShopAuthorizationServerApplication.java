package com.sibghat.vape_shop_authorization_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@SpringBootApplication
public class VapeShopAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VapeShopAuthorizationServerApplication.class, args);
		System.out.println(ClientAuthenticationMethod.CLIENT_SECRET_BASIC);
	}

}
