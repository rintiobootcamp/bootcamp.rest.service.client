package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Notification;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class NotificationClient implements AppConstant {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public NotificationClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }

    public void sendNotification(Notification notification) throws IOException {
        String uri = propertiesFileUtils.getAppUrl("notification-service-fonctionnel-create");
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(uri);
    }
}
