package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denuncia;
import com.example.apidenuncias.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DenunciaService {
    @Autowired
    private DenunciaRepository denunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository){
        this.denunciaRepository = denunciaRepository;
    }

    public Denuncia save(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }
}
