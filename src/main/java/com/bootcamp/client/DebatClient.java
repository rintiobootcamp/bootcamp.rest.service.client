package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Debat;
import com.bootcamp.utils.PropertiesFileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class DebatClient {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public DebatClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }
//    public List<Debat> getByEntityTypeClient(String entityType) throws IOException {
//        propertiesFileUtils= new PropertiesFileUtils();
//        String uri = propertiesFileUtils.getAppUrl("like-service-fonctionnel-get-like");
//
//        String uriSufix="/"+entityType;
//        uri+=uriSufix;
//        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
//        String jsonData = response.getBody();
//        List<Debat> debats  = GsonUtils.getObjectFromJson(jsonData, List.class);
//        return debats;
//    }

    public List<Debat> getByEntityType(String entityType ,long startDate,long endDate) throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("debat.getAllByAllentity");
//        System.out.println("***le lien***** "+uri);
        String uriSufix="/"+entityType+"?startDate="+startDate+"&endDate="+endDate;
        uri+=uriSufix;
        System.out.println("***le PREFIX***** "+uri);
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        List<Debat> debats  = GsonUtils.getObjectFromJson(jsonData, List.class);
        return debats;
    }


}
