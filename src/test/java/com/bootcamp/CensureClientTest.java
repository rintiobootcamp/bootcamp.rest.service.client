package com.bootcamp;

import com.bootcamp.client.CensureClient;
import com.bootcamp.entities.Censure;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CensureClientTest {

    @Test
    public void getCommentByEntity() throws IOException {
        String entityType = "AXE";
        int entityId = 1;
        CensureClient censureClient = new CensureClient();
        List<Censure> censures = censureClient.getCensureByEntity(entityType,entityId);
        Gson gson = new Gson();
        String data = gson.toJson(censures);
        System.out.println(data);
    }
}
