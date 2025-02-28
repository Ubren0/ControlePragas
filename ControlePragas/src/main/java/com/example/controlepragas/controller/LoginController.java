package com.example.controlepragas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String exibirLogin() {
        // Verifica se o usuário já está logado (exemplo com sessão)
        return "redirect:/dashboard.html"; // Redireciona para a dashboard diretamente
    }
}

