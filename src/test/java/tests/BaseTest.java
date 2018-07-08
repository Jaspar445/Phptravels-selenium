package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.*;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
