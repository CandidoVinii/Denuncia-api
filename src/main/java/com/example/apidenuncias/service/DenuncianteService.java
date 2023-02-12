package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denunciante;
import com.example.apidenuncias.repository.DenuncianteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DenuncianteService {
    @Autowired
    private DenuncianteRepository denuncianteRepository;

    public DenuncianteService(DenuncianteRepository denuncianteRepository) {
        this.denuncianteRepository = denuncianteRepository;
    }

    public Denunciante save(Denunciante denunciante) {
        return denuncianteRepository.save(denunciante);
    }

}
