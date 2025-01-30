package com.contatos.simulado.controller;

import com.contatos.simulado.model.M_Usuario;
import com.contatos.simulado.service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Usuario {

    @GetMapping("/")
    public String getLogin() {
        return "usuario/login";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam("nome") String nome,
                            @RequestParam("senha") String senha,
                            HttpSession session) {
        M_Usuario m_usuario = S_Usuario.login(nome, senha);
        if (m_usuario == null) {
            return "redirect:/";
        }
        session.setAttribute("usuario",m_usuario);
        return "redirect:/contato";
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("apelido") String apelido,
                               @RequestParam("senha") String senha,
                               @RequestParam("conf_senha") String conf_senha,
                               HttpSession session) {
        M_Usuario m_usuario = S_Usuario.cadastrarUsuario(nome, apelido, senha, conf_senha);
        if (m_usuario==null) {
            return "redirect:/";
        }
        session.setAttribute("usuario",m_usuario);
        return "redirect:/contato";
    }
}
