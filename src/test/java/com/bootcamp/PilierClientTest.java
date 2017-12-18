//package com.bootcamp;
//
//import com.bootcamp.client.AxeClient;
//import com.bootcamp.client.PilierClient;
//import com.bootcamp.entities.Axe;
//import com.bootcamp.entities.Pilier;
//import com.google.gson.Gson;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class PilierClientTest {
//    @Test
//    public void getPiliers() throws IOException {
//       PilierClient pilierClient = new PilierClient();
//        List<Pilier> piliers = pilierClient.findAll();
//        Gson gson = new Gson();
//        for(Pilier current:piliers){
//            String data = gson.toJson(current);
//            System.out.println(data);
//        }
//
//    }
//    @Test
//    public void getPilierById() throws IOException {
//        PilierClient pilierClient = new PilierClient();
//        Pilier pilier = pilierClient.getById(1);
//        Gson gson = new Gson();
//        String data = gson.toJson(pilier);
//        System.out.println(data);
//    }
//}
