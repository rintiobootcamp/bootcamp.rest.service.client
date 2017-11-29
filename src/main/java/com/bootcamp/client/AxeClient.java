package com.bootcamp.client;

import com.bootcamp.commons.models.Criterias;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Axe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class AxeClient implements AppConstant {
    RestTemplate restTemplate;

    public AxeClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }



    public Axe[] findAll() throws IOException {
        String uri =  AXE_CLIENT_BASE_URI+AXE_CLIENT_GET_URI;
        Axe[] axes = restTemplate.getForObject(uri,  Axe[].class);

        return axes;

    }

//    public AxeWss findAll(String query, String fields) throws IOException {
//        String uri =  AXE_CLIENT_BASE_URI+AXE_CLIENT_GET_URI;
//        AxeWss axeWss = restTemplate.getForObject(uri,  AxeWss.class);
//
//        return axeWss;
//
//    }
//
//    public AxeWs create(Axe axe) throws UnsupportedEncodingException, IOException{
//        String uri =  AXE_CLIENT_BASE_URI+AXE_CLIENT_CREATE_URI;
//        HttpEntity<Axe> request = new HttpEntity<>(axe);
//        AxeWs axeWs = restTemplate.postForObject(uri, request, AxeWs.class);
//
//        return axeWs;
//    }

}
