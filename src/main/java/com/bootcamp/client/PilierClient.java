package com.bootcamp.client;

import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Pilier;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class PilierClient implements AppConstant {

    RestTemplate restTemplate;

    public PilierClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }

    public Pilier[] findAll() throws IOException {
        String uri = PILIER_CLIENT_BASE_URI + PILIER_CLIENT_GET_URI;
        Pilier[] piliers = restTemplate.getForObject(uri, Pilier[].class);

        return piliers;

    }

//    public PilierWss findAll() throws IOException {
//        String uri =  AXE_CLIENT_BASE_URI+AXE_CLIENT_GET_URI;
//        PilierWss pilierWss = restTemplate.getForObject(uri,  PilierWss.class);
//
//        return pilierWss;
//
//    }
//
//    public PilierWss findAll(String query, String fields) throws IOException {
//        String uri =  AXE_CLIENT_BASE_URI+AXE_CLIENT_GET_URI;
//        PilierWss pilierWss = restTemplate.getForObject(uri,  PilierWss.class);
//
//        return pilierWss;
//
//    }
//
//    public PilierWs create(Pilier pilier) throws UnsupportedEncodingException, IOException{
//        String uri =  AXE_CLIENT_BASE_URI+AXE_CLIENT_CREATE_URI;
//        HttpEntity<Pilier> request = new HttpEntity<>(pilier);
//        PilierWs pilierWs = restTemplate.postForObject(uri, request, PilierWs.class);
//
//        return pilierWs;
//    }
}
