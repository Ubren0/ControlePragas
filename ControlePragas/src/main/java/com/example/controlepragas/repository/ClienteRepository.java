package com.example.controlepragas.repository;

import com.example.controlepragas.model.Clientes; // Aqui precisa ser o caminho certo!
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
}
