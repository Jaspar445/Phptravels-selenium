package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.FIREFOX;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    public DriverManager() {}

    //Method setWebDriver set type of browser for a given thread
    public static void setWebDriver(BrowserType browserType) {

        WebDriver browser = null;

        //If the object is BrowserType to null, then the browser will be selected for a given thread
        //defined in the file configuration.properties
        if(browserType == null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

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

        if(!browserTypeThreadLocal.get().equals(FIREFOX)) {
            //Calling quit method for actual thread
            webDriverThreadLocal.get().quit();
        }

        //Calling remove method delete webdriver for actual thread
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}
