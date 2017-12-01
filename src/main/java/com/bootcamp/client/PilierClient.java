package com.bootcamp.client;


import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Pilier;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class PilierClient implements AppConstant {

    RestTemplate restTemplate;

    public PilierClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }

    public List<Pilier> findAll() throws IOException {
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie-service-fonctionnel-get-all-pilier");
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Pilier>>() {}.getType();
        List<Pilier> piliers = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);

        return piliers;

    }

    public Pilier getById(int id) throws IOException{
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();

        String uri=propertiesFileUtils.getAppUrl("categorie-service-fonctionnel-get-all-pilier");
        String uriSufix="/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Pilier pilier = GsonUtils.getObjectFromJson(jsonData,Pilier.class);
        return pilier;

    }

}
