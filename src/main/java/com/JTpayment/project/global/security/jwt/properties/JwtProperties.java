package com.JTpayment.project.global.security.jwt.properties;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.Key;

@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final Key accessSecret;
    private final Key refreshSecret;

    private JwtProperties(String accessSecret, String refreshSecret) {
        this.accessSecret = Keys.hmacShaKeyFor(accessSecret.getBytes());
        this.refreshSecret = Keys.hmacShaKeyFor(refreshSecret.getBytes());
    }

    public Key getAccessSecret() {
        return accessSecret;
    }

    public Key getRefreshSecret() {
        return refreshSecret;
    }
}
