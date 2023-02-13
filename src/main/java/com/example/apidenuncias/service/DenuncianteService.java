package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denunciante;
import com.example.apidenuncias.repository.DenuncianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DenuncianteService {
    @Autowired
    private DenuncianteRepository denuncianteRepository;

    public DenuncianteService(DenuncianteRepository denuncianteRepository) {
        this.denuncianteRepository = denuncianteRepository;
    }

    public Denunciante saveDenunciante(Map<String, Object> denunciaMap) {
        Map<String, Object> denuncianteMap = (Map<String, Object>) denunciaMap.get("denunciante");
        Denunciante denunciante = new Denunciante();
        denunciante.setNome((String) denuncianteMap.get("nome"));
        denunciante.setCpf((String) denuncianteMap.get("cpf"));

        denunciante = denuncianteRepository.save(denunciante);
        return denunciante;
    }

    public Denunciante save(Denunciante denunciante) {
        return denuncianteRepository.save(denunciante);
    }

}
