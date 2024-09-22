package com.infnet.RelatoriosAPI.controller;

import com.infnet.RelatoriosAPI.model.LogAtividade;
import com.infnet.RelatoriosAPI.model.RelatorioDTO;
import com.infnet.RelatoriosAPI.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatoriosController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
    public ResponseEntity<List<RelatorioDTO>> gerarRelatorio() {
        List<RelatorioDTO> relatorio = relatorioService.gerarRelatorio();
        return ResponseEntity.ok(relatorio);
    }


    @GetMapping("/log/{id}")
    public ResponseEntity<LogAtividade> pegarLogPorId(@PathVariable Long id) {
        LogAtividade log = relatorioService.pegarLogPorId(id);
        if (log != null) {
            return ResponseEntity.ok(log);
        }
        return ResponseEntity.notFound().build();
    }
}
