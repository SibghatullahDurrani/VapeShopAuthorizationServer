package com.sibghat.vape_shop_authorization_server.services;


import com.sibghat.vape_shop_authorization_server.dtos.SecurityUserDto;
import com.sibghat.vape_shop_authorization_server.security.SecurityUser;
import com.sibghat.vape_shop_authorization_server.services.user.IUserServices;
import com.sibghat.vape_shop_authorization_server.services.user.UserServices;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final IUserServices userServices;

    public JpaUserDetailsService(UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUserDto user = userServices.findUserByUsername(username);

        return new SecurityUser(user);
    }
}
