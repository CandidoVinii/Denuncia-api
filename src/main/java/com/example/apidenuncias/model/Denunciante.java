package com.example.apidenuncias.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_DENUNCIANTE")
public class Denunciante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
