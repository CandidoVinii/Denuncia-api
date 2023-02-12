package com.example.apidenuncias.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_DENUNCIA")
public class Denuncia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @ManyToOne
    @JoinColumn(name="denunciante_id")
    private Denunciante denunciante;

    @OneToOne
    @JoinColumn(name="endereco_id")
    private Endereco endereco;

    private Date criacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Denunciante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}