package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterTest
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
