package com.infnet.AutenticacaoAPI.controller;

import com.infnet.AutenticacaoAPI.model.AuthRequest;
import com.infnet.AutenticacaoAPI.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Autenticação simples fictícia (pode ser substituída por uma verificação real)
        if ("usuario".equals(authRequest.getUsername()) && "senha".equals(authRequest.getPassword())) {
            String token = jwtTokenProvider.criarToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }
}
