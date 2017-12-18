package com.bootcamp.client;


import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Pilier;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class PilierClient {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public PilierClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils= new PropertiesFileUtils();
    }

    public List<Pilier> findAll() throws IOException {
        String uri=propertiesFileUtils.getAppUrl("categorie.getAllPilier");
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Pilier>>() {}.getType();
        List<Pilier> piliers = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);

        return piliers;
    }

    public Pilier create(Pilier pilier) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("categorie.createPilier");

        String requestBody = GsonUtils.toJSONWithoutClassName(pilier);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String apiResponse = restTemplate.postForObject(uri,
                request, String.class);
        pilier = GsonUtils.getObjectFromJson(apiResponse, Pilier.class);

        return pilier;
    }

    public Pilier getById(int id) throws IOException{
        String uri=propertiesFileUtils.getAppUrl("categorie.getAllByIdPilier");
        String uriSufix="/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Pilier pilier = GsonUtils.getObjectFromJson(jsonData,Pilier.class);
        return pilier;

    }

}
