package com.bootcamp.client;

import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ProjetClient implements AppConstant {
    RestTemplate restTemplate;

    public ProjetClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }

    public Projet[] findAll() throws IOException {
        String uri =  PROJET_CLIENT_BASE_URI+PROJET_CLIENT_GET_URI;
        Projet[] projets = restTemplate.getForObject(uri,  Projet[].class);

        return projets;

    }

}
