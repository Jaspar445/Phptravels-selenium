package configuration;

import driver.BrowserType;

public class TestRunProperties {

    //getBrowserToRun method returns which browser should be run
    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

    //getIsRemoteRun method returns value inform about local or remote start-up
    public static boolean getIsRemoteRun() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }

    //getGridUrl method returns Grid URL
    public static String getGridUrl() {
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }
}
