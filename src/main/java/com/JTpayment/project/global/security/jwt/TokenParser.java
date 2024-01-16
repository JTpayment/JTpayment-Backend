package com.JTpayment.project.global.security.jwt;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;
import com.JTpayment.project.global.security.jwt.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@RequiredArgsConstructor
public class TokenParser {
    private final JwtProperties jwtProperties;
    private final UserDetailsService userDetailsService;

    @AllArgsConstructor
    public enum Token {
        ACCESS_TYPE("access"),
        REFRESH_TYPE("refresh"),
        TOKEN_PREFIX("Bearer "),
        AUTHORITY("authority");
        final String value;
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null) {
            return null;
        }

        return parseToken(token);
    }

    private String parseToken(String token) {
        if(token.startsWith(Token.TOKEN_PREFIX.value)) {
            return token.replace(Token.TOKEN_PREFIX.value, "");
        } else {
            return null;
        }
    }

    private Claims getTokenBody(String token, Key secret) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new BasicException(ErrorCode.TOKEN_IS_EXPIRED);
        } catch (JwtException e) {
            throw new BasicException(ErrorCode.TOKEN_IS_INVALID);
        }
    }

    public String getTokenSubject(String token, Key secret) {
        return getTokenBody(token, secret).getSubject();
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getTokenSubject(token, jwtProperties.getAccessSecret()));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
}
