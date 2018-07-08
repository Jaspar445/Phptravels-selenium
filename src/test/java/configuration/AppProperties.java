package configuration;

/*
 * AppProperties class delivers properties connected with application
 */

public class AppProperties {

    //getAllUrl method returns app.url property calling getProperty method
    public static String getAllUrl() {
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }
}
