package com.bootcamp.client;


import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Axe;
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


public class AxeClient {
    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public AxeClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils= new PropertiesFileUtils();
    }



    public List<Axe> findAll() throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie.getAllPilier");
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Axe>>() {}.getType();
        List<Axe> axes = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);

        return axes;
    }

    public Axe create(Axe axe) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("categorie.createAxe");

        String requestBody = GsonUtils.toJSONWithoutClassName(axe);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String apiResponse = restTemplate.postForObject(uri,
                request, String.class);
        axe = GsonUtils.getObjectFromJson(apiResponse, Axe.class);

        return axe;
    }

    public Axe getById(int id) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("categorie.getAxeById");
        String uriSufix="/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Axe axe = GsonUtils.getObjectFromJson(jsonData,Axe.class);
        return axe;

    }
}
