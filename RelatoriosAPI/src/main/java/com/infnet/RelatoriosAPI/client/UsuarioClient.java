package com.infnet.RelatoriosAPI.client;

import com.infnet.RelatoriosAPI.model.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-api", url = "http://localhost:8080")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO getUsuarioById(@PathVariable("id") Long id);
}
