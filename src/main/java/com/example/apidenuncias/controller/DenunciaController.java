package com.example.apidenuncias.controller;

import com.example.apidenuncias.model.Response;
import com.example.apidenuncias.model.Denuncia;
import com.example.apidenuncias.service.DenunciaComposition;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class DenunciaController {
    @Autowired
    private DenunciaComposition denunciaComposition;


    @PostMapping("/denuncias")
    public ResponseEntity<Response<Denuncia>> salvar(@RequestBody Map<String, Object> denunciaMap) throws JsonProcessingException {
        if (denunciaMap.get("latitude") == null || denunciaMap.get("latitude").toString().isEmpty() ||
                denunciaMap.get("longitude") == null || denunciaMap.get("longitude").toString().isEmpty() ||
                ((Map) denunciaMap.get("denunciante")).get("nome") == null || ((Map) denunciaMap.get("denunciante")).get("nome").toString().isEmpty() ||
                ((Map) denunciaMap.get("denunciante")).get("cpf") == null || ((Map) denunciaMap.get("denunciante")).get("cpf").toString().isEmpty() ||
                ((Map) denunciaMap.get("denuncia")).get("titulo") == null || ((Map) denunciaMap.get("denuncia")).get("titulo").toString().isEmpty() ||
                ((Map) denunciaMap.get("denuncia")).get("descricao") == null || ((Map) denunciaMap.get("denuncia")).get("descricao").toString().isEmpty()) {
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("message", "Request inválido.");
            errorDetails.put("code", "01");
            Map<String, Object> error = new HashMap<>();
            error.put("error", errorDetails);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(error));
        }
        try {
            Denuncia denuncia = denunciaComposition.save(denunciaMap);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>(denuncia));
        } catch (ServiceException e) {
            Map<String, Object> error = new HashMap<>();
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("message", "Endereço não encontrado para essa localidade.");
            errorDetails.put("code", "02");
            error.put("error", errorDetails);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(error));
        }
    }
}
