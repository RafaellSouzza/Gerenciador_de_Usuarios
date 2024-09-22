package com.infnet.UsuariosAPI.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import com.infnet.UsuariosAPI.model.Usuario;
import com.infnet.UsuariosAPI.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsuariosServiceTest {

    @Mock
    private UsuarioRepository usuariosRepository;

    @InjectMocks
    private UsuarioService usuariosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuscarUsuarioPorId() {
        Usuario mockUsuario = new Usuario();
        mockUsuario.setId(1L);
        mockUsuario.setNome("João");
        mockUsuario.setSobrenome("Silva");
        mockUsuario.setDataNascimento(LocalDate.of(1990, 1, 1));

        when(usuariosRepository.findById(1L)).thenReturn(Optional.of(mockUsuario));

        Optional<Usuario> resultado = usuariosService.pegarPorId(1L);

        assertNotNull(resultado);
        assertEquals("João", resultado.get().getNome());
        assertEquals("Silva", resultado.get().getSobrenome());
        assertEquals(LocalDate.of(1990, 1, 1), resultado.get().getDataNascimento());
    }
    
}
