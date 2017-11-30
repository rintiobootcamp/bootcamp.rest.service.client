package com.bootcamp.tests;

import com.bootcamp.client.PilierClient;
import com.bootcamp.entities.Pilier;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author soul
 */
public class PilierControllerTest {

    @Test
    public PilierControllerTest() throws IOException {
        PilierClient pilierClient=new PilierClient();
        Pilier[] listePiliers=pilierClient.findAll();
        Assert.assertNotNull(listePiliers);
    }

}
