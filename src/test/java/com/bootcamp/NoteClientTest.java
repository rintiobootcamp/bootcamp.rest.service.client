//package com.bootcamp;
//
//import com.bootcamp.client.AxeClient;
//import com.bootcamp.client.NoteClient;
//import com.bootcamp.client.ProjetClient;
//import com.bootcamp.commons.enums.EntityType;
//import com.bootcamp.commons.ws.usecases.pivotone.NoteWS;
//import com.bootcamp.entities.Axe;
//import com.bootcamp.entities.Note;
//import com.bootcamp.entities.Projet;
//import com.google.gson.Gson;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class NoteClientTest {
//
//    //@Test
//    public void getNote() throws IOException {
//        NoteClient noteClient = new NoteClient();
//        NoteWS note = noteClient.getNote(EntityType.PROJET.name(), 7);
//        Gson gson = new Gson();
//        String data = gson.toJson(note);
//        System.out.println(data);
//    }
//}
