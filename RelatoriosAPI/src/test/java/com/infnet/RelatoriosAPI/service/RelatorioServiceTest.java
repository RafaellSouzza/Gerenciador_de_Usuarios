package com.infnet.RelatoriosAPI.service;

import com.infnet.RelatoriosAPI.model.RelatorioDTO;
import com.infnet.RelatoriosAPI.model.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class RelatorioServiceTest {

    @Autowired
    private RelatorioService relatorioService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testarGeracaoDeRelatorio() {
        UsuarioDTO[] usuarios = {
                new UsuarioDTO(1L, "Rafael", "Soares", LocalDate.of(1993, 6, 15)),
                new UsuarioDTO(2L, "Maria", "Silva", LocalDate.of(1995, 8, 22))
        };

        Mockito.when(restTemplate.getForObject(any(String.class), any(Class.class)))
                .thenReturn(usuarios);

        List<RelatorioDTO> relatorio = relatorioService.gerarRelatorio();

        assertEquals(2, relatorio.size());
        assertEquals("Rafael Soares", relatorio.get(0).getNomeCompleto());
        assertEquals("Maria Silva", relatorio.get(1).getNomeCompleto());
    }
}
