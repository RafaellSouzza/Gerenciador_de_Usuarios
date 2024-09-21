package com.infnet.AutenticacaoAPI.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtTokenProvider {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Gera uma chave secreta
    private final long validityInMilliseconds = 3600000; // 1 hora

    public String criarToken(String username) {
        Date agora = new Date();
        Date validade = new Date(agora.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)  // Define o subject diretamente
                .setIssuedAt(agora)
                .setExpiration(validade)
                .signWith(secretKey)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
