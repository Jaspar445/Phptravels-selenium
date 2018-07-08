package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * PropertyLoader class is loading properties file
 */

public class PropertiesLoader {

    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    //getPropertiesFromFile method load values from properties file
    public Properties getPropertiesFromFile(String propertiesFileName) {

        //InputStream object helps to load properties file
        InputStream inputStream = null;

        //Properties object keeps values
        Properties properties = new Properties();
        try {
            logger.info("Trying to load properties with file name: " + propertiesFileName);

            //Load properties file and initialize inputStream object
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if(inputStream != null) {
                properties.load(inputStream);
                logger.info("Successfully loaded properties for file: " + propertiesFileName);
            } else {
                throw new FileNotFoundException("Property file '" + propertiesFileName + "' not found in the classpath");
            }
        } catch(IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IOException!");
        } finally {
            closeResource(inputStream);
        }
        return properties;
    }

    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
