package com.example.controlepragas.repository;

import com.example.controlepragas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // Alterado de Integer para Long

    Optional<Usuario> findByLogin(String login);
}
