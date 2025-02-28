package com.example.controlepragas.controller;

import com.example.controlepragas.model.Usuario;
import com.example.controlepragas.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControler {

    private final UsuarioRepository usuarioRepository;

    public UsuarioControler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // ✅ Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);

        if (usuario.isPresent()) {
            System.out.println("Usuário encontrado: " + usuario.get().getLogin());
            if (usuario.get().getSenha().equals(senha)) {
                return ResponseEntity.ok("Login bem-sucedido");
            } else {
                System.out.println("Senha incorreta para: " + login);
            }
        } else {
            System.out.println("Usuário não encontrado: " + login);
        }

        return ResponseEntity.status(401).body("Usuário inexistente ou senha inválida");
    }
}
