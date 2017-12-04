package com.bootcamp;

import com.bootcamp.client.AxeClient;
import com.bootcamp.client.LikeClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LikeClientTest {

    @Test
    public void getLike() throws IOException {
//        LikeClient likeClient = new LikeClient();
//        Like like = likeClient.
//        Gson gson = new Gson();
//        String data = gson.toJson(Like);
//        System.out.println(data);
    }

    //@Test
    public void getProjetById() throws IOException {
        AxeClient axeClient = new AxeClient();
        Axe axe = axeClient.getById(1);
        Gson gson = new Gson();
        String data = gson.toJson(axe);
        System.out.println(data);
    }
}
