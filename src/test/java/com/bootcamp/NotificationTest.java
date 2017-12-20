/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.client.NotificationClient;
import com.bootcamp.commons.enums.Action;
import com.bootcamp.commons.ws.usecases.pivotone.NotificationInput;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class NotificationTest {
    //@Test
    public void testNotification (){
        NotificationClient client = new NotificationClient();
        NotificationInput input = new NotificationInput();
        input.setAction(Action.NEW_DEBAT);
        input.setEntityId(3);
        input.setEntityType("DEBAT");
        input.setTitre("Les défis du millénaire");
        
        //String uri = "http://localhost:8092/notification/notifications";

//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject( uri, input, NotificationInput.class);

        //System.out.println(uri);
        
        try {
            client.sendNotification(input);
        } catch (IOException ex) {
            Logger.getLogger(NotificationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
