package com.contatos.simulado.repository;


import com.contatos.simulado.model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Usuario extends JpaRepository<M_Usuario, Long> {
    @Query(value="select * from usuario where nome = :nome and senha = :senha limit 1", nativeQuery = true)
    public M_Usuario getUsuarioFromNomeAndSenha(@Param("nome") String nome, @Param("senha") String senha);
}
