package com.example.currencyconverter.kotlin.security

import com.example.currencyconverter.kotlin.service.JwtUserDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(private val jwtUserDetailsService: JwtUserDetailsService, private val jwtTokenUtil: JwtTokenUtil) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val requestTokenHeader: String? = request.getHeader("authorization")

        var jwtToken: String? = null
        var username: String? = null
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7)
            username = jwtTokenUtil.getUsernameFromToken(jwtToken)
        }else{
            logger.warn("JWT Token does not begin with Bearer String")
        }

        if (username != null && SecurityContextHolder.getContext().authentication == null){
            val userDetails : UserDetails = jwtUserDetailsService.loadUserByUsername(username)

            if(jwtTokenUtil.validateToken(jwtToken, userDetails)!!){
                val usernamePasswordAuthenticationToken: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }
        filterChain.doFilter(request, response)
    }
}