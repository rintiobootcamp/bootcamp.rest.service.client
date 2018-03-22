package com.bootcamp;

import com.bootcamp.client.DebatClient;
import com.bootcamp.entities.Debat;
import com.bootcamp.entities.LikeTable;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DebatClientTest {
    @Test
    public void getByEntityType() throws IOException {
        String entityType = "PROJET";
        String startD="";
        String endD="";
        DebatClient debatClient = new DebatClient();
        List <Debat> likeTables = debatClient.getByEntityType(entityType,startD,endD);
        Gson gson = new Gson();
        String data = gson.toJson(likeTables);
        System.out.println(data);
    }

    @Test
    public void getAllByEntityId() throws IOException {
        String entityType = "AXE";
        int entityId = 1;
        DebatClient debatClient = new DebatClient();
        List <Debat> debats = debatClient.getAllByEntityId(entityType,entityId);
        Gson gson = new Gson();
        String data = gson.toJson(debats);
        System.out.println(data);
    }

//    @Test
//    public void getAllByEntity() throws IOException {
//        String entityType = "AXE";
//        GregorianCalendar sdate = new GregorianCalendar();
//        GregorianCalendar edate = new GregorianCalendar();
//
//        sdate.set(Calendar.DAY_OF_MONTH,15);
//        sdate.set(Calendar.MONTH,2);
//        sdate.set(Calendar.YEAR,2018);
//
//        edate.set(Calendar.DAY_OF_MONTH,30);
//        edate.set(Calendar.MONTH,2);
//        edate.set(Calendar.YEAR,2018);
//
//        DebatClient debatClient = new DebatClient();
//        List <Debat> debats = debatClient.getByEntityType(entityType,sdate.getTimeInMillis(),edate.getTimeInMillis());
//        Gson gson = new Gson();
//        String data = gson.toJson(debats);
//        System.out.println(data);
//    }
}
