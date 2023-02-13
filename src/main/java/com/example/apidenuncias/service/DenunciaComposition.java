package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Denuncia;
import com.example.apidenuncias.model.Denunciante;
import com.example.apidenuncias.model.Endereco;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DenunciaComposition {
    @Autowired
    private DenuncianteService denuncianteService;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private DenunciaService denunciaService;

    @Autowired
    private LocalizacaoService localizacaoService;


    public Denuncia save(Map<String, Object> denunciaMap) throws JsonProcessingException {
        Endereco endereco = enderecoService.saveEndereco((Map<String, Object>) denunciaMap);
        Denunciante denunciante = denuncianteService.saveDenunciante((Map<String, Object>) denunciaMap);
        Denuncia denuncia = denunciaService.saveDenuncia(denunciaMap, denunciante, endereco);

        return denuncia;
    }
}
