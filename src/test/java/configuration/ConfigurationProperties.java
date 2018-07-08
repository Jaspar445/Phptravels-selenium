package configuration;

import java.util.Properties;

/*
 * ConfigurationProperties class stores all loaded values from properties file
 */

public class ConfigurationProperties {

    private static Properties properties;

    private ConfigurationProperties() {}

    //setProperties method load properties object to static object of Properties type
    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }

    //getProperties method returns all loaded properties if they are not null
    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Please set properties using setProperties() before calling getProperties()");
        }
        return properties;
    }
}
