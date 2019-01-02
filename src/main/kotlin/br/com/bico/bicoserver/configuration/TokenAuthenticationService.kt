package br.com.bico.bicoserver.configuration

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import java.util.Date

object TokenAuthenticationService {

    private val EXPIRATIONTIME: Long = 864000000
    private val SECRET = "S&nh@Bik0Secreta"
    private val TOKEN_PREFIX = "Biko"
    private val HEADER_STRING = "Authorization"

    fun addAuthentication(res: HttpServletResponse, username: String) {
        val JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact()

        val token = "$TOKEN_PREFIX $JWT"
        res.addHeader(HEADER_STRING, token)

        try {
            res.outputStream.print(token)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun getByToken(token: String): Authentication? {
        if (!token.contains(TOKEN_PREFIX)){
            return null
        }
        val user = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .body
                .subject

        return if (user != null) UsernamePasswordAuthenticationToken(user, null, null) else null
    }

    fun getAuthentication(request: HttpServletRequest): Authentication? {
        val token = request.getHeader(HEADER_STRING)
        return if (token != null) {
            getByToken(token)
        } else null
    }
}