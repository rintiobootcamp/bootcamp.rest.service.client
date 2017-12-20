package com.bootcamp;

import com.bootcamp.client.DebatClient;
import com.bootcamp.entities.Debat;
import com.bootcamp.entities.LikeTable;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class DebatClientTest {
    @Test
    public void getByEntityType() throws IOException {
        String entityType = "PROJET";
        long startD=0;
        long endD=0;
        DebatClient debatClient = new DebatClient();
        List <Debat> likeTables = debatClient.getByEntityType(entityType,startD,endD);
        Gson gson = new Gson();
        String data = gson.toJson(likeTables);
        System.out.println(data);
    }
}
