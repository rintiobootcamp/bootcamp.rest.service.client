package com.bootcamp;

import com.bootcamp.client.CommentaireClient;
import com.bootcamp.client.LikeClient;
import com.bootcamp.entities.Commentaire;
import com.bootcamp.entities.LikeTable;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LikeClientTest {
    @Test
    public void getAllLikeOrUnlikeByEntity() throws IOException {
        String entityType = "PROJET";
        long startD=1513580119339L;
        long endD=1513580181020L;
        LikeClient likeClient = new LikeClient();
        List <LikeTable> likeTables = likeClient.getAllLikeOrUnlikeByEntity(entityType,startD,endD);
        Gson gson = new Gson();
        String data = gson.toJson(likeTables);
        System.out.println(data);
    }
}
