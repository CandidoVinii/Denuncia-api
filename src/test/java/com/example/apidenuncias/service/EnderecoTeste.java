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

    private static final String LOGRADOURO = "Rua 1";
    private static final String BAIRRO = "São Pedro";
    private static final String CIDADE = "Laranjeiras";
    private static final String ESTADO = "São Paulo";
    private static final String PAIS = "Brasil";
    private static final String CEP = "36037000";
    private static final Double LONGITUDE = -47.887251273393815;
    private static final Double LATITUDE = -47.887251273393815;
    @MockBean
    private EnderecoRepository enderecoRepository;

    private EnderecoService sut;

    private Endereco endereco;

    @Before
    public void dummy() {
        sut = new EnderecoService(enderecoRepository);

        endereco = new Endereco();
        endereco.setLogradouro(LOGRADOURO);
        endereco.setBairro(BAIRRO);
        endereco.setCidade(CIDADE);
        endereco.setEstado(ESTADO);
        endereco.setPais(PAIS);
        endereco.setCep(CEP);
        endereco.setLongitude(String.valueOf(LONGITUDE));
        endereco.setLatitude(String.valueOf(LATITUDE));
    }

    @Test
    public void save_endereco() {
        sut.save(endereco);

        verify(enderecoRepository).save(endereco);
    }
}
