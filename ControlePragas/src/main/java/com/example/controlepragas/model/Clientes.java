package com.example.controlepragas.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente") // Garantindo que o nome da coluna no banco está correto
    private Integer idCliente;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 20)
    private String telefone;

    @Column(length = 255)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String endereco;

    @Column(nullable = false, length = 20)
    private String cnpjcpf;

    @Column(name = "administradora_nome", length = 255)
    private String administradoraNome;

    @Column(name = "administradora_contato", length = 50)
    private String administradoraContato;

    @Column(name = "supervisor_nome", length = 255)
    private String supervisorNome;

    @Column(name = "supervisor_contato", length = 50)
    private String supervisorContato;

    @Column(name = "valor_faturamento", precision = 10, scale = 2)
    private BigDecimal valorFaturamento;

    @Column(name = "forma_pagamento", length = 50)
    private String formaPagamento;

    @Column(name = "tipo_contrato", length = 50)
    private String tipoContrato;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

}
