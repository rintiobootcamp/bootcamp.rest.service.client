package com.bootcamp;

import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Projet;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

//
//import com.bootcamp.client.ProjetClient;
//import com.bootcamp.client.SecteurClient;
//import com.bootcamp.entities.Projet;
//import com.bootcamp.entities.Secteur;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.List;
//
public class ProjetClientTest {
    @Test
    public void getProjets() throws IOException {
        ProjetClient projetClient = new ProjetClient();
        List<Projet> projets = projetClient.findAll();
        String d = GsonUtils.toJSONWithoutClassName(projets);
        System.out.println("Result "+d);

    }
//
//    //@Test
//    /*public void getProjetById() throws IOException {
//        ProjetClient projetClient = new ProjetClient();
//        Projet projet = projetClient.getById(1);
//        Gson gson = new Gson();
//        String data = gson.toJson(projet);
//        System.out.println(data);
//    }*/
//
}
