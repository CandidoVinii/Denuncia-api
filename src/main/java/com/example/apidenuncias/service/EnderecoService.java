package com.example.apidenuncias.service;

import com.example.apidenuncias.model.Endereco;
import com.example.apidenuncias.repository.EnderecoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private LocalizacaoService localizacaoService;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco saveEndereco(Map<String, Object> denunciaMap) throws JsonProcessingException {
        Map<String, Object> enderecoMap = (Map<String, Object>) localizacaoService.getGeolocation((Double) denunciaMap.get("latitude"), (Double) denunciaMap.get("longitude"));
        Endereco endereco = new Endereco();
        endereco.setLogradouro((String) enderecoMap.get("logradouro"));
        endereco.setBairro((String) enderecoMap.get("bairro"));
        endereco.setCidade((String) enderecoMap.get("cidade"));
        endereco.setEstado((String) enderecoMap.get("estado"));
        endereco.setCep((String) enderecoMap.get("cep"));
        endereco.setPais((String) enderecoMap.get("pais"));
        endereco.setLatitude(String.valueOf((Double) denunciaMap.get("latitude")));
        endereco.setLongitude(String.valueOf((Double) denunciaMap.get("longitude")));

        endereco = enderecoRepository.save(endereco);

        return endereco;
    }
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
