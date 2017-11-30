package com.bootcamp.client;

import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Axe;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

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
