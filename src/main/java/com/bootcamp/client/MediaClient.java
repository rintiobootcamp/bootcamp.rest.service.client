package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Media;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MediaClient {
    RestTemplate restTemplate;

    public MediaClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
    }

    public List<Media> getByEntityTypeAndEntityId(int entityId, String entityType) throws IOException {
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("media.getByEntity");
        uri= uri+"/"+entityId+"/"+entityType;

        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        Type typeOfObjectsListNew = new TypeToken<List<Media>>() {}.getType();
        List<Media> medias = GsonUtils.getObjectFromJson(jsonData,typeOfObjectsListNew);
        return medias;

    }



}
