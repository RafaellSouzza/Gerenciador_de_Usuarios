package com.infnet.RelatoriosAPI.repository;


import com.infnet.RelatoriosAPI.model.LogAtividade;
import com.infnet.RelatoriosAPI.model.RelatorioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<LogAtividade, Long> {
}
