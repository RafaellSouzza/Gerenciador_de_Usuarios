package com.infnet.AutenticacaoAPI.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider {

    private final String secretKey = "mySecretKey"; // Você pode configurar isso em application.properties
    private final long validityInMilliseconds = 3600000; // 1 hora

    public String criarToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date agora = new Date();
        Date validade = new Date(agora.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(agora)
                .setExpiration(validade)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
