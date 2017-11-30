package com.bootcamp;

import com.bootcamp.utils.PropertiesFileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by darextossa on 11/30/17.
 */
public class PropertiesUtilsTest {
    private static Logger logger = LogManager.getLogger(PropertiesUtilsTest.class);

    @Test
    public void propertiesFileTest() throws IOException {
        PropertiesFileUtils propertiesFileUtils= new PropertiesFileUtils();
        logger.debug(propertiesFileUtils.getAppUrl("categorie-service-fonctionnel"));
    }
}
