package com.bootcamp;

import com.bootcamp.client.AxeClient;
import com.bootcamp.client.NoteClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Note;
import com.bootcamp.entities.Projet;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class NoteClientTest {

    @Test
    public void getNote(EntityType entityType, int id) throws IOException {
        NoteClient noteClient = new NoteClient();
        Note note = noteClient.getNote(EntityType.PROJET, 7);
        Gson gson = new Gson();
        String data = gson.toJson(note);
        System.out.println(data);
    }
    
    @Test
    public void createNote() throws IOException {
//        NoteClient noteClient = new NoteClient();
//        noteClient.
//        Gson gson = new Gson();
//        for(Axe current:axes){
//            String data = gson.toJson(current);
//            System.out.println(data);
//        }

    }

    @Test
    public void getProjetById() throws IOException {
        AxeClient axeClient = new AxeClient();
        Axe axe = axeClient.getById(1);
        Gson gson = new Gson();
        String data = gson.toJson(axe);
        System.out.println(data);
    }
}
