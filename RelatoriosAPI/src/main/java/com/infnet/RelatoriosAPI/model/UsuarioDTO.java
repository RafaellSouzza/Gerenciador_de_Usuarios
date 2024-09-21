package com.infnet.RelatoriosAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
}
