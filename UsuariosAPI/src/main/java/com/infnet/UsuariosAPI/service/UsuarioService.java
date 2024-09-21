package com.infnet.UsuariosAPI.service;

import com.infnet.UsuariosAPI.model.Usuario;
import com.infnet.UsuariosAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> pegarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> pegarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
