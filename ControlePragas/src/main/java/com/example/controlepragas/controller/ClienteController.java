package com.example.controlepragas.controller;

import com.example.controlepragas.model.Clientes;
import com.example.controlepragas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*") // Permite requisições do frontend
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // 🔹 Retorna todos os clientes
    @GetMapping
    public List<Clientes> listarClientes() {
        return clienteRepository.findAll();
    }

    // 🔹 Retorna um cliente específico pelo ID
    @GetMapping("/{id}")
    public Clientes buscarCliente(@PathVariable Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // 🔹 Adiciona um novo cliente
    @PostMapping
    public Clientes adicionarCliente(@RequestBody Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    // 🔹 Atualiza um cliente existente
    @PutMapping("/{id}")
    public Clientes atualizarCliente(@PathVariable Integer id, @RequestBody Clientes clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setEndereco(clienteAtualizado.getEndereco());
                    cliente.setCnpjcpf(clienteAtualizado.getCnpjcpf());
                    cliente.setAdministradoraNome(clienteAtualizado.getAdministradoraNome());
                    cliente.setAdministradoraContato(clienteAtualizado.getAdministradoraContato());
                    cliente.setSupervisorNome(clienteAtualizado.getSupervisorNome());
                    cliente.setSupervisorContato(clienteAtualizado.getSupervisorContato());
                    cliente.setValorFaturamento(clienteAtualizado.getValorFaturamento());
                    cliente.setFormaPagamento(clienteAtualizado.getFormaPagamento());
                    cliente.setTipoContrato(clienteAtualizado.getTipoContrato());
                    cliente.setDataInicio(clienteAtualizado.getDataInicio());
                    return clienteRepository.save(cliente);
                })
                .orElse(null);
    }

    // 🔹 Deleta um cliente pelo ID
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }
}
