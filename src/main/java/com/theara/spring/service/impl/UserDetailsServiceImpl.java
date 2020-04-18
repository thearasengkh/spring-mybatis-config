package com.theara.spring.service.impl;

import com.theara.spring.model.MData;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Theara Seng
 * created on Apr 18, 2020
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        MData ipUserInfo = new MData();
        ipUserInfo.setString("email", email);
        MData userInfo = this.userService.retrieveUserInfo(ipUserInfo);

        if (userInfo == null) {
            throw new UsernameNotFoundException(
                    "No user found with email: "+ email);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        User user = new User(
                userInfo.getString("email"),
                userInfo.getString("password"),
                enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                getAuthorities(userInfo.getString("role"))
        );

        return user;
    }

    private static List<GrantedAuthority> getAuthorities (String... roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
