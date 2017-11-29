package com.bootcamp.client;


import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Pilier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

public class PilierClient implements AppConstant {
    RestTemplate restTemplate;

    public PilierClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
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
