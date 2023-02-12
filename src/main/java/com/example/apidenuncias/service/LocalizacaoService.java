package com.example.apidenuncias.service;

import com.example.apidenuncias.repository.EnderecoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class LocalizacaoService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Cacheable("geolocation")
    public Map<String, Object> getGeolocation(Double latitude, Double longitude) throws JsonProcessingException {
        String url = "https://www.mapquestapi.com/geocoding/v1/reverse?key=nT5dm3pi2FTfmjEKpfR48CnETTSs3MMe"
                + "&location=" + latitude + "," + longitude
                + "&outFormat=json&thumbMaps=true";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        Map<String, Object> resultJson = new HashMap<>();
        resultJson.put("logradouro", root.path("results").get(0).path("locations").get(0).path("street").asText());
        resultJson.put("bairro", root.path("results").get(0).path("locations").get(0).path("adminArea6").asText());
        resultJson.put("cidade", root.path("results").get(0).path("locations").get(0).path("adminArea5").asText());
        resultJson.put("estado", root.path("results").get(0).path("locations").get(0).path("adminArea3").asText());
        resultJson.put("pais", root.path("results").get(0).path("locations").get(0).path("adminArea1").asText());
        resultJson.put("cep", root.path("results").get(0).path("locations").get(0).path("postalCode").asText());

        return resultJson;
    }
}
