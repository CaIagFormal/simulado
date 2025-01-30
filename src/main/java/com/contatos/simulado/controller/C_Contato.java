package com.contatos.simulado.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Contato {

    @GetMapping("/contato")
    public String getContato(HttpSession session) {
        if (session.getAttribute("usuario")==null){
            return "redirect:/";
        }
        return "contato/cadastro";
    }
}
