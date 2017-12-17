//package com.bootcamp;
//
//import com.bootcamp.client.ProjetClient;
//import com.bootcamp.client.SecteurClient;
//import com.bootcamp.commons.utils.GsonUtils;
//import com.bootcamp.entities.Projet;
//import com.bootcamp.entities.Secteur;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class SecteurClientTest {
//    private static Logger logger = LogManager.getLogger(PropertiesUtilsTest.class);
//
//    @Test
//    public void getSecteurs() throws IOException{
//        SecteurClient secteurClient = new SecteurClient();
//        List<Secteur> secteurs = secteurClient.findAll();
//
//        Gson gson = new Gson();
//
//            for(Secteur current:secteurs){
//                String data = gson.toJson(current);
//                System.out.println(data);
//            }
//
//    }
//
//    @Test
//    public void getProjetById() throws IOException {
//        SecteurClient secteurClient = new SecteurClient();
//        Secteur secteur = secteurClient.getById(1);
//        Gson gson = new Gson();
//        String data = gson.toJson(secteur);
//        System.out.println(data);
//    }
//}
