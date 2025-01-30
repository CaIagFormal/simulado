package com.contatos.simulado.model;


import jakarta.persistence.*;

@Entity
@Table(name="contato")
public class M_Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private M_Usuario usuario;

    private String nome;

    private String numero;

    private String email;
}
