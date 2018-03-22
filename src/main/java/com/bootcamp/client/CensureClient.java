package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Censure;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class CensureClient {


    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public CensureClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public List<Censure> getCensureByEntity(String entityType,int entityId) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("censure.getByEntity");

        String uriSufix="/"+entityType+"/"+entityId;
        uri+=uriSufix;
        System.out.println("***le lien***** "+uri);
         String response = restTemplate.getForObject(uri,String.class);
        Type typeOfObjectsListNew = new TypeToken<List<Censure>>() {
        }.getType();
        List<Censure> censures = GsonUtils.getObjectFromJson(response, typeOfObjectsListNew);

        return censures;
    }


}
