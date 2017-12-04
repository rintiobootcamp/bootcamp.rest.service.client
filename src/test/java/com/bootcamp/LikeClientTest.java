package com.bootcamp;

import com.bootcamp.client.AxeClient;
import com.bootcamp.client.LikeClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.commons.ws.usecases.pivotone.LikeWS;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LikeClientTest {

    @Test
    public void getLike() throws IOException {
        LikeClient likeClient = new LikeClient();
        LikeWS like = likeClient.getClient(EntityType.PROJET.name(), 7);
        Gson gson = new Gson();
        String data = gson.toJson(like);
        System.out.println(data);
    }

}
