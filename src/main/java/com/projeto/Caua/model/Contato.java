package com.projeto.Caua.model;

import javax.persistence.*;

@Entity
@Table(name = "contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_contato")
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String adicionais;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }
}
