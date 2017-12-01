package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ProjetClient implements AppConstant {
    RestTemplate restTemplate;

    public ProjetClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }

    public List<Projet> findAll() throws IOException {
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("projet-service-fonctionnel-get-all-projet");
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Projet>>() {}.getType();
        List<Projet> projets = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);


        return projets;

    }

    public Projet getById(int id) throws IOException{
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("projet-service-fonctionnel-get-projet-byId");
        String uriSufix="/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Projet projet = GsonUtils.getObjectFromJson(jsonData,Projet.class);
        return projet;

    }

}
