package com.example.currencyconverter.kotlin.api

import com.example.currencyconverter.kotlin.domain.JwtRequest
import com.example.currencyconverter.kotlin.domain.JwtResponse
import com.example.currencyconverter.kotlin.security.JwtTokenUtil
import com.example.currencyconverter.kotlin.service.JwtUserDetailsService

import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class JwtAuthenticationController(val jwtTokenUtil: JwtTokenUtil, val userDetailsService: JwtUserDetailsService) {

    @PostMapping("/authenticate")
    fun createAuthenticationToken(@RequestBody authenticationRequest: JwtRequest)
            : ResponseEntity<JwtResponse> {

        val userDetails: UserDetails = userDetailsService.loadUserByUsername(authenticationRequest.username)
        val token: String = jwtTokenUtil.generateToken(userDetails)
        return ResponseEntity.ok(JwtResponse(token))
    }
}

