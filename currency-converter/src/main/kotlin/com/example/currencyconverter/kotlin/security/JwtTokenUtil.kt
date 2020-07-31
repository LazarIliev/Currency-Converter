package com.example.currencyconverter.kotlin.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function

@Component
class JwtTokenUtil {
    companion object {
       const val JWT_TOKEN_VALIDITY = 1000 * 3600.toLong()
    }

    @Value("\${jwt.secret}")
    private val secret: String? = null

    fun getUsernameFromToken(token: String?): String? {
        return getClaimFromToken(token, Function { obj: Claims? -> obj!!.subject })
    }

    fun getExpirationDateFromToken(token: String?): Date? {
        return getClaimFromToken(token, Function { obj: Claims? -> obj!!.expiration })
    }

    fun <T> getClaimFromToken(token: String?, claimsResolver: Function<Claims?, T>): T {
        val claims = getAllClaimsFromToken(token!!)
        return claimsResolver.apply(claims)
    }

    private fun getAllClaimsFromToken(token: String): Claims? {
        return Jwts.parser().setSigningKey(secret!!.toByteArray())
                .parseClaimsJws(token).body
    }

    private fun isTokenExpired(token: String): Boolean? {
        val expiration = getExpirationDateFromToken(token)
        return expiration!!.before(Date())
    }

    fun generateToken(userDetails: UserDetails): String {
        val claims: Map<String, Any> = HashMap()
        val username = userDetails.username
        return doGenerateToken(claims, username)
    }

    private fun doGenerateToken(claims: Map<String, Any>, subject: String): String {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret!!.toByteArray()).compact()
    }

    fun validateToken(token: String?, userDetails: UserDetails): Boolean? {
        val username = getUsernameFromToken(token)
        return username == userDetails.username && !isTokenExpired(token!!)!!
    }
}


