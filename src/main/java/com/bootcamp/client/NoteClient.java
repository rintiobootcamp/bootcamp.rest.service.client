package com.bootcamp.client;

import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.ws.usecases.pivotone.NoteWS;
import com.bootcamp.constants.AppConstant;
import com.bootcamp.entities.Note;
import com.bootcamp.utils.PropertiesFileUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 *
 * @author leger
 */
public class NoteClient implements AppConstant {

    RestTemplate restTemplate;
    PropertiesFileUtils propertiesFileUtils;

    public NoteClient() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        restTemplate = new RestTemplate(factory);
        propertiesFileUtils = new PropertiesFileUtils();
    }
    
    public NoteWS getNote(String entityType, int id) throws IOException {
        propertiesFileUtils= new PropertiesFileUtils();
        String uri = propertiesFileUtils.getAppUrl("note-service-fonctionnel-get-note");
        
        String uriSufix="/"+entityType+"/"+id;
        uri+=uriSufix;
        ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String jsonData = response.getBody();
        NoteWS note  = GsonUtils.getObjectFromJson(jsonData,NoteWS.class);
        return note;
    }
    
    public Note createNote(Note note) throws IOException {
        String uri= propertiesFileUtils.getAppUrl("note-service-fonctionnel-create-note");

        String requestBody = GsonUtils.toJSONWithoutClassName(note);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        HttpEntity request = new HttpEntity(requestBody, headers);

        String apiResponse = restTemplate.postForObject(uri,
                request, String.class);
        note = GsonUtils.getObjectFromJson(apiResponse, Note.class);

        return note;
    }

}