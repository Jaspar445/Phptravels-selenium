package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://www.phptravels.net");
    }

    @AfterTest
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
