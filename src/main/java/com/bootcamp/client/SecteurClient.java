package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Secteur;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class SecteurClient implements AppConstant {
    RestTemplate restTemplate;

    public SecteurClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }

    public  List<Secteur>  findAll() throws IOException {
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie-service-fonctionnel-get-all-secteur");
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Secteur>>() {}.getType();
        List<Secteur> secteurs = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);


        return secteurs;

    }

    public Secteur getById(int id) throws IOException{
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie-service-fonctionnel-get-secteur-byId");
        String uriSufix="/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Secteur secteur = GsonUtils.getObjectFromJson(jsonData,Secteur.class);
        return secteur;

    }

}
