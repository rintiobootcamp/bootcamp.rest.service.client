package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Secteur;
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

public class SecteurClient {
    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public SecteurClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils= new PropertiesFileUtils();
    }

    public  List<Secteur>  findAll() throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie.getAllSecteu");
        String response = restTemplate.getForObject(uri,String.class);
        Type typeOfObjectsListNew = new TypeToken<List<Secteur>>() {}.getType();
        List<Secteur> secteurs = GsonUtils.getObjectFromJson(response,typeOfObjectsListNew);
        return secteurs;
    }

    public Secteur create(Secteur secteur) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("categorie.createSecteur");

        String requestBody = GsonUtils.toJSONWithoutClassName(secteur);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String apiResponse = restTemplate.postForObject(uri,
                request, String.class);
        secteur = GsonUtils.getObjectFromJson(apiResponse, Secteur.class);

        return secteur;
    }

    public Secteur getById(int id) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie.getSecteurById");
        String uriSufix="/"+id;
        uri+=uriSufix;
       String response = restTemplate.getForObject(uri,String.class);
        Secteur secteur = GsonUtils.getObjectFromJson(response,Secteur.class);
        return secteur;

    }

}
