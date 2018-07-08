package driver;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserFactory {

    //getWebDriver method allows select driver.
    public static WebDriver getBrowser(BrowserType browserType) {
        switch(browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
                return new FirefoxDriver();
            case OPERA:
                System.setProperty("webdriver.opera.driver", LocalWebDriverProperties.getOperaWebDriverLocation());
                return new OperaDriver();
            case EDGE:
                System.setProperty("webdriver.edge.driver", LocalWebDriverProperties.getEdgeWebDriverLocation());
                return new EdgeDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", LocalWebDriverProperties.getInternetExplorerWebDriverLocation());
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
