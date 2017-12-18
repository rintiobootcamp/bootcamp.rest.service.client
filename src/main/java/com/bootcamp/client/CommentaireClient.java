package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Commentaire;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CommentaireClient implements AppConstant {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public CommentaireClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public List<Commentaire> getByEntity(String entityType, int entityId) throws IOException {
        propertiesFileUtils = new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("commentaire-service-fonctionnel-get-Commentaire-by-entity");
        String uriSufix = "/" + entityType + "/" + entityId;
        uri += uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {
        }.getType();
        List<Commentaire> commentaires = GsonUtils.getObjectFromJson(jsonData, typeOfObjectsListNew);

        return commentaires;
    }

    public Commentaire getById(int id) throws IOException {
        propertiesFileUtils = new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("commentaire-service-fonctionnel-get-Commentaire-by-entity");
        String uriSufix = "/" + id;
        uri += uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Commentaire>>() {
        }.getType();
        Commentaire commentaire = GsonUtils.getObjectFromJson(jsonData, typeOfObjectsListNew);

        return commentaire;

    }
}
