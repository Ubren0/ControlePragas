package com.example.controlepragas.service;

import com.example.controlepragas.model.Usuario;
import com.example.controlepragas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario); // Salva a senha sem criptografia
    }

    public Optional<Usuario> autenticar(String login, String senha) {
        return usuarioRepository.findByLogin(login)
                .filter(usuario -> usuario.getSenha().equals(senha)); // Comparação direta
    }
}
