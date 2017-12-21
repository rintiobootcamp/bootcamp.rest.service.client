package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.ws.usecases.pivotone.NotificationInput;
import com.bootcamp.utils.PropertiesFileUtils;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class NotificationClient {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public NotificationClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public void sendNotification(NotificationInput notification) throws IOException {
        //String uri= propertiesFileUtils.getAppUrl("notification-service-fonctionnel-create");

        String requestBody = GsonUtils.toJSONWithoutClassName(notification);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String uri=propertiesFileUtils.getAppUrl("notification.uri");
//        String uri = "http://localhost:8092/notification/notifications";

        boolean apiResponse = restTemplate.postForObject(uri, notification, Boolean.class);
//        System.out.println(apiResponse);
    }
}
