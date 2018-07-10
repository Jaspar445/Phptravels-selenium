package configuration;

/*
 * LocalWebDriverProperties class delivers properties connected with paths to .exe files and browser on which test should be executed
 */

public class LocalWebDriverProperties {

    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getFirefoxWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }

    public static String getOperaWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("opera.driver.location");
    }

    public static String getEdgeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("edge.driver.location");
    }

    public static String getInternetExplorerWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("ie.driver.location");
    }
}
