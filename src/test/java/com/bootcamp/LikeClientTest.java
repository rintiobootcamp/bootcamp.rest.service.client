package com.bootcamp;

import com.bootcamp.client.CommentaireClient;
import com.bootcamp.client.LikeClient;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.ws.usecases.pivotone.LikeWS;
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
        String startD="";
        String endD="";
        LikeClient likeClient = new LikeClient();
        LikeWS likes = likeClient.getAllLikeOrUnlikeByEntity(entityType,1);
        Gson gson = new Gson();
        String data = GsonUtils.toJSONWithoutClassName(likes);
        System.out.println(data);
    }
}
