package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public DriverManager() {}

    public static WebDriver getWebDriver() {

        if(driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if(!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        //Null value remove object of WebDriver class from Java memory.
        driver = null;
    }
}
