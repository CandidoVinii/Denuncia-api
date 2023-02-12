package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denuncia;
import com.example.apidenuncias.repository.DenunciaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DenunciaTeste {

    private static final String TITULO = "Bueiro Entupido";
    private static final String DESCRICAO = "A situação na rua 1 é deplorável";
    @MockBean
    private DenunciaRepository denunciaRepository;

    private DenunciaService sut;

    private Denuncia denuncia;

    @Before
    public void dummy() {
        sut = new DenunciaService(denunciaRepository);

        denuncia = new Denuncia();
        denuncia.setTitulo(TITULO);
        denuncia.setDescricao(DESCRICAO);
    }

    @Test
    public void save_denuncia() {
        sut.save(denuncia);

        verify(denunciaRepository).save(denuncia);
    }
}
