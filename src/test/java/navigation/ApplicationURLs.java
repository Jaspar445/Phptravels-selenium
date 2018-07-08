package navigation;

import configuration.AppProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String LOGIN_URL = APPLICATION_URL + "/login";
    public static final String SIGNUP_URL = APPLICATION_URL + "/register";
}
