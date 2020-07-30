package com.example.currencyconverter.service;

import com.example.currencyconverter.domain.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class JwtUserDetailsService implements UserDetailsService {
    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "admin",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "admin"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username))
        {
            Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                    .filter(user -> user.getUsername().equals(username)).findFirst();
            if (findFirst.isEmpty()) {
                throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
            }
            return findFirst.get();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}