package com.contatos.simulado.service;


import com.contatos.simulado.model.M_Usuario;
import com.contatos.simulado.repository.R_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {

    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        S_Usuario.r_usuario = r_usuario;
    }

    public static M_Usuario cadastrarUsuario(String nome, String apelido,String senha, String conf_senha) {
        if (!senha.equals(conf_senha)||nome.trim().isBlank()||senha.trim().isBlank()||apelido.trim().isBlank()) {
            return null;
        }

        M_Usuario m_usuario = new M_Usuario();

        m_usuario.setNome(nome);
        m_usuario.setSenha(senha);
        m_usuario.setApelido(apelido);

        return r_usuario.save(m_usuario);
    }

    public static M_Usuario login(String nome, String senha) {
        return r_usuario.getUsuarioFromNomeAndSenha(nome, senha);
    }


}
