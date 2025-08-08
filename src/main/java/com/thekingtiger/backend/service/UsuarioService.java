
package com.thekingtiger.backend.service;

import com.thekingtiger.backend.model.Usuario;
import com.thekingtiger.backend.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository UsuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository UsuarioRepository) {
        this.UsuarioRepository = UsuarioRepository;
    }

    public List<Usuario> getUsuario() {
        return this.UsuarioRepository.findAll();
    }
}