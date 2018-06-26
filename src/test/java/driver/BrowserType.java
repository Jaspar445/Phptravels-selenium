package driver;

public enum BrowserType {

    //List of available browsers.
    CHROME("chrome"),
    FIREFOX("firefox"),
    OPERA("opera"),
    EDGE("edge"),
    IE("internetexplorer");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
