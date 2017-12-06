package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.ws.usecases.pivotone.LikeWS;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.utils.PropertiesFileUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author leger
 */
public class LikeClient implements AppConstant {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public LikeClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }
    
public LikeWS getClient(String entityType, int id) throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("like-service-fonctionnel-get-like");
        
        String uriSufix="/"+entityType+"/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        LikeWS like  = GsonUtils.getObjectFromJson(jsonData, LikeWS.class);
        return like;
    }
    
    public LikeWS createLike(LikeWS likeWS) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("like-service-fonctionnel-create");

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

}
