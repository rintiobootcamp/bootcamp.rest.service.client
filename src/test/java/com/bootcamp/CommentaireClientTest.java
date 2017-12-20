package com.bootcamp;

import com.bootcamp.client.CommentaireClient;
import com.bootcamp.entities.Commentaire;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CommentaireClientTest {
    @Test
    public void getAllCommentByAllEntity() throws IOException {
        String entityType = "PROJET";
        long startD=0;
        long endD=0;
        CommentaireClient commentaireClient = new CommentaireClient();
        List <Commentaire> commentaires = commentaireClient.getAllCommentByAllEntity(entityType,startD,endD);
        Gson gson = new Gson();
        String data = gson.toJson(commentaires);
        System.out.println(data);
    }
}
