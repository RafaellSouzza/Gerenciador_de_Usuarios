package com.infnet.RelatoriosAPI.service;

import com.infnet.RelatoriosAPI.model.RelatorioDTO;
import com.infnet.RelatoriosAPI.model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    private RestTemplate restTemplate;

    private final String usuariosApiUrl = "http://localhost:8080/api/usuarios";

    public List<RelatorioDTO> gerarRelatorio() {
        UsuarioDTO[] usuarios = restTemplate.getForObject(usuariosApiUrl, UsuarioDTO[].class);

        return Arrays.stream(usuarios)
                .map(this::converterParaRelatorio)
                .collect(Collectors.toList());
    }

    private RelatorioDTO converterParaRelatorio(UsuarioDTO usuario) {
        String nomeCompleto = usuario.getNome() + " " + usuario.getSobrenome();
        int idade = calcularIdade(usuario.getDataNascimento());
        return new RelatorioDTO(nomeCompleto, idade);
    }

    private int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
