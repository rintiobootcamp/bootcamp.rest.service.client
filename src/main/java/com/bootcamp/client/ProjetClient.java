package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Projet;
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

public class ProjetClient {
    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public ProjetClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils= new PropertiesFileUtils();
    }

    public List<Projet> findAll() throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("projet.getAllProjet");
        String response = restTemplate.getForObject(uri,String.class);
        Type typeOfObjectsListNew = new TypeToken<List<Projet>>() {}.getType();
        List<Projet> projets = GsonUtils.getObjectFromJson(response,typeOfObjectsListNew);
        return projets;
    }

    public Projet create(Projet projet) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("projet.createProjet");
        String requestBody = GsonUtils.toJSONWithoutClassName(projet);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);
        String apiResponse = restTemplate.postForObject(uri,
                request, String.class);
        projet = GsonUtils.getObjectFromJson(apiResponse, Projet.class);
        return projet;
    }

    public Projet getById(int id) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("projet.getProjetById");
        String uriSufix="/"+id;
        uri+=uriSufix;
        String response = restTemplate.getForObject(uri,String.class);
        Projet projet = GsonUtils.getObjectFromJson(response,Projet.class);
        return projet;

    }

}
