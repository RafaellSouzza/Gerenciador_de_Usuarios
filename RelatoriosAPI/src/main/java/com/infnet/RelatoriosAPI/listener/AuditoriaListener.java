package com.infnet.RelatoriosAPI.listener;


import com.infnet.RelatoriosAPI.model.UsuarioDTO;
import com.infnet.RelatoriosAPI.service.RelatorioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaListener {

    @Autowired
    private RelatorioService relatorioService;

    @RabbitListener(queues = "userQueue")
    public void receberUsuarioCriado(UsuarioDTO usuario) {
        relatorioService.registrarLog("Cadastro de Usuário", "Administrador", "Usuário " + usuario.getNome() + " cadastrado.");
    }
}
