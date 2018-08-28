package com.bootcamp.client;

import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Question;
import com.bootcamp.utils.PropertiesFileUtils;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

public class SondageClient {
    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public List<Question> getUnesQuestion() throws Exception{
        propertiesFileUtils= new PropertiesFileUtils();
        String uri=propertiesFileUtils.getAppUrl("sondage.getprimes");
        String response = restTemplate.getForObject(uri,String.class);
        Type typeOfObjectsListNew = new TypeToken<List<Projet>>() {}.getType();
        List<Question> sondages = GsonUtils.getObjectFromJson(response,typeOfObjectsListNew);
        return sondages;
    }
}
