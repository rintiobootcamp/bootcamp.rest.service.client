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
        propertiesFileUtils= new PropertiesFileUtils();
    }
//
//    public Commentaire create(Commentaire commentaire) throws IOException {
//        String uri= propertiesFileUtils.getAppUrl("commentaire-service-fonctionnel-create-commentaire");
//
//        String requestBody = GsonUtils.toJSONWithoutClassName(commentaire);
//        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
//        headers.add("Accept", "application/json");
//        headers.add("Content-Type", "application/json");
//        HttpEntity request = new HttpEntity(requestBody, headers);
//
//        String apiResponse = restTemplate.postForObject(uri,
//                request, String.class);
//        commentaire = GsonUtils.getObjectFromJson(apiResponse, Commentaire.class);
//
//        return commentaire;
//    }

//    public List<Commentaire> getByEntity(String entityType,int entityId) throws IOException{
//        propertiesFileUtils= new PropertiesFileUtils();
//        String uri=propertiesFileUtils.getAppUrl("commentaire-service-fonctionnel-get-Commentaire-by-entity");
//        String uriSufix="/"+entityType+"/"+entityId;
//        uri+=uriSufix;
//        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
//        String jsonData = response.getBody();
//        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {}.getType();
//        List<Commentaire> commentaires = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);
//
//        return commentaires;
//
//    }

    public List<Commentaire> getCommentByEntity(String entityType,int entityId) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("commentaire.getAllByEntityType");

        String uriSufix="/"+entityType+"/"+entityId;
        System.out.println("***le lien***** "+uri);
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {}.getType();
        List<Commentaire> commentaires = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);

        return commentaires;

    }

    public List<Commentaire> getAllCommentByAllEntity(String entityType,long startDate, long endDate) throws IOException{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("commentaire.getAllByEntity");
        String uriSufix="/"+entityType+"?startDate="+startDate+"&endDate="+endDate;
        uri+=uriSufix;
        System.out.println("***** Le suffixe ****"+uri);
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {}.getType();
        List<Commentaire> commentaires = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);
        return commentaires;

    }

//
//    public List<Commentaire> getByEntityTypeClient(String entityType) throws IOException {
//        propertiesFileUtils= new PropertiesFileUtils();
//        String uri = propertiesFileUtils.getAppUrl("like-service-fonctionnel-get-like");
//
//        String uriSufix="/"+entityType;
//        uri+=uriSufix;
//        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
//        String jsonData = response.getBody();
//        List<Commentaire> commentaires  = GsonUtils.getObjectFromJson(jsonData, List.class);
//        return commentaires;
//    }


}
