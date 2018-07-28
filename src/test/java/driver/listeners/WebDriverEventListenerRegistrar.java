package driver.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverEventListenerRegistrar {

    //registerWebDriverEventListener method registers information from the DriverEventListener class
    //and synchronized keyword causes access to the method to have only one thread at a time
    public synchronized static WebDriver registerWebDriverEventListener(WebDriver driver) {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        DriverEventListener driverEventListener = new DriverEventListener();
        return eventFiringWebDriver.register(driverEventListener);
    }
}
