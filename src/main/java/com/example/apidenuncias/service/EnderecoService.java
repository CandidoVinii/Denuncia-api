package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Endereco;
import com.example.apidenuncias.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
