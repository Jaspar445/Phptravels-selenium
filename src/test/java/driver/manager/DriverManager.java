package driver.manager;

import driver.BrowserFactory;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.FIREFOX;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public DriverManager() {}

    public static WebDriver getWebDriver() {

        //Check if webDriverThreadLocal has null value for actual thread
        if(webDriverThreadLocal.get() == null) {
            //Calling getBrowser method and added to ThreadLocal class using set method
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser());
        }

        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        //Calling close method for actual thread
        webDriverThreadLocal.get().close();

        if(!getBrowserToRun().equals(FIREFOX)) {
            //Calling quit method for actual thread
            webDriverThreadLocal.get().quit();
        }

        //Calling remove method delete webdriver for actual thread
        webDriverThreadLocal.remove();
    }
}
