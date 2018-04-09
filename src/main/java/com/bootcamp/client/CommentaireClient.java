package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Commentaire;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;



public class CommentaireClient {


    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public CommentaireClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public List<Commentaire> getCommentByEntity(String entityType,int entityId) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("commentaire.getByEntity");

        String uriSufix="/"+entityType+"/"+entityId;
        //System.out.println("***le lien***** "+uri);
        uri+=uriSufix;
         String response = restTemplate.getForObject(uri,String.class);
        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {
        }.getType();
        List<Commentaire> commentaires = GsonUtils.getObjectFromJson(response, typeOfObjectsListNew);

        return commentaires;
    }


    public List<Commentaire> getAllCommentByAllEntity(String entityType, String startDate, String endDate) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("commentaire.getAllByEntity");
        String uriSufix="/"+entityType+"?startDate="+startDate+"&endDate="+endDate;
        uri+=uriSufix;

        String response = restTemplate.getForObject(uri,String.class);
        System.out.println("response from client "+response.toString());
        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {}.getType();
        List<Commentaire> commentaires = GsonUtils.getObjectFromJson(response,typeOfObjectsListNew);
        return commentaires;

    }

}
