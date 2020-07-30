package com.example.currencyconverter.kotlin.service

//import com.example.currencyconverter.domain.JwtUserDetails//todo kotlin
import com.example.currencyconverter.kotlin.domain.JwtUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService : UserDetailsService{
    companion object {
        var inMemoryUserList : List<JwtUserDetails> = listOf(JwtUserDetails(1L, "admin",
                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "admin"))
    }

    override fun loadUserByUsername(username: String): UserDetails {
        if ("admin" == username){
            return inMemoryUserList[0]
        }else{
            throw UsernameNotFoundException("User not found with username: $username")
        }
    }
}