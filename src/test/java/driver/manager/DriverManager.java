package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX;
    private static WebDriver driver;

    public DriverManager() {}

    public static WebDriver getWebDriver() {

        if(driver == null) {
            driver = BrowserFactory.getBrowser(BrowserType.CHROME);
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if(!BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        //Null value remove object of WebDriver class from Java memory.
        driver = null;
    }
}
