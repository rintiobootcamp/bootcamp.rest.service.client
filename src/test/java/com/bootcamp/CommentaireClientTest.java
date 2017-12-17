//package com.bootcamp;
//
//import com.bootcamp.client.CommentaireClient;
//import com.bootcamp.entities.Commentaire;
//import com.google.gson.Gson;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class CommentaireClientTest {
//    @Test
//    public void getProjetByEntity() throws IOException {
//        String entityType = "PROJET";
//        int entityId = 1;
//        CommentaireClient commentaireClient = new CommentaireClient();
//        List <Commentaire> commentaires = commentaireClient.getByEntity(entityType,entityId);
//        Gson gson = new Gson();
//        String data = gson.toJson(commentaires);
//        System.out.println(data);
//    }
//}
