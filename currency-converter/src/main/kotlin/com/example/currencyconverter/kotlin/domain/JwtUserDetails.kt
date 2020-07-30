package com.example.currencyconverter.kotlin.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class JwtUserDetails(private var id: Long, private var username: String, private var password : String, private var role : String) : UserDetails {

    //private val  authorities :  Collection<GrantedAuthority>
    private val authorities: Collection<out GrantedAuthority?>? = listOf(SimpleGrantedAuthority(role))
//    init {
//        authorities.add(SimpleGrantedAuthority(role))
//    }

    override fun getAuthorities(): Collection<out GrantedAuthority?>? {
        return authorities
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        return username
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }
}