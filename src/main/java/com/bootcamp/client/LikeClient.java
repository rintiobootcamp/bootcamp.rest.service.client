package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.ws.usecases.pivotone.LikeWS;
import com.bootcamp.entities.Commentaire;
import com.bootcamp.entities.LikeTable;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author leger
 */
public class LikeClient{

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public LikeClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

public LikeWS getClient(String entityType, int id) throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("like.like");
        System.out.println("***le lien***** "+uri);

        String uriSufix="/"+entityType+"/"+id;
        uri+=uriSufix;
        String response = restTemplate.getForObject(uri,String.class);
        LikeWS like  = GsonUtils.getObjectFromJson(response, LikeWS.class);
        return like;
    }

    public LikeWS createLike(LikeWS likeWS) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("like.create");

        String requestBody = GsonUtils.toJSONWithoutClassName(likeWS);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String apiResponse = restTemplate.postForObject(uri,
                request, String.class);
        likeWS = GsonUtils.getObjectFromJson(apiResponse, LikeWS.class);

        return likeWS;
    }


    public List<LikeTable> getAllLikeOrUnlikeByEntity(String entityType,long startDate,long endDate) throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("like.getAllByAllentity");
//        System.out.println("***le lien***** "+uri);
        String uriSufix="/"+entityType+"?startDate="+startDate+"&endDate="+endDate;
        uri+=uriSufix;
//        System.out.println("***le suffix***** "+uri);
        String response = restTemplate.getForObject(uri,String.class);
        Type typeOfObjectsListNew = new TypeToken<List<LikeTable>>() {}.getType();
        List<LikeTable> likes  = GsonUtils.getObjectFromJson(response, typeOfObjectsListNew);
        return likes;
    }

}
