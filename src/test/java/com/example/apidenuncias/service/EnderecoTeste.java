package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Endereco;
import com.example.apidenuncias.repository.EnderecoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class EnderecoTeste {

    @MockBean
    private EnderecoRepository enderecoRepository;

    private EnderecoService sut;

    private Endereco endereco;

    @Before
    public void dummy() {
        sut = new EnderecoService(enderecoRepository);
    }

    @Test
    public void save_address_respository() {
        sut.save(endereco);

        verify(enderecoRepository).save(endereco);
    }
}
