package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denuncia;
import com.example.apidenuncias.model.Denunciante;
import com.example.apidenuncias.model.Endereco;
import com.example.apidenuncias.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class DenunciaService {
    @Autowired
    private DenunciaRepository denunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository){
        this.denunciaRepository = denunciaRepository;
    }

    public Denuncia saveDenuncia(Map<String, Object> denunciaMap, Denunciante denunciante, Endereco endereco) {
        Map<String, Object> denunciaDados = (Map<String, Object>) denunciaMap.get("denuncia");
        Denuncia denuncia = new Denuncia();
        denuncia.setTitulo((String) denunciaDados.get("titulo"));
        denuncia.setDescricao((String.valueOf((String) denunciaDados.get("descricao"))));
        denuncia.setDenunciante(denunciante);
        denuncia.setEndereco(endereco);
        denuncia.setCriacao(new Date());

        denuncia = denunciaRepository.save(denuncia);

        return denuncia;
    }
    public void save(Denuncia denuncia) {
        denunciaRepository.save(denuncia);
    }
}
