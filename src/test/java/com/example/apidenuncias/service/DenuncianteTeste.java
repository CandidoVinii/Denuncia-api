package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denunciante;
import com.example.apidenuncias.repository.DenuncianteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DenuncianteTeste {

    private static final String NOME = "Vinicius Aquino";

    private static final String CPF = "18052438705";

    @MockBean
    private DenuncianteRepository denuncianteRepository;

    private DenuncianteService sut;

    private Denunciante denunciante;

    @Before
    public void dummy() {
        sut = new DenuncianteService();

        denunciante = new Denunciante();
        denunciante.setNome(NOME);
        denunciante.setCpf(CPF);
    }

    @Test
    public void save_denunciante() {
        sut.save(denunciante);

        verify(denuncianteRepository).save(denunciante);
    }
}
