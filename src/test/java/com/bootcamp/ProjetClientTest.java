package com.bootcamp;

import com.bootcamp.client.ProjetClient;
import com.bootcamp.client.SecteurClient;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ProjetClientTest {
    @Test
    public void getProjets() throws IOException {
        ProjetClient projetClient = new ProjetClient();
        List<Projet> projets = projetClient.findAll();
        Gson gson = new Gson();
        for(Projet current:projets){
            String data = gson.toJson(current);
            System.out.println(data);
        }

    }
}
