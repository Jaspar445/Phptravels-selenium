package pages;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class UserAccountPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"body-section\"]/div/div[1]/div/div/div/img")
    private WebElement userImage;

    public UserAccountPage() {
        //Initialization of webelements from UserAccountPage class
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    //Fluent Interface is not used, because isUserImageIsDipalyed method is using for assertion
    public boolean isUserImageIsDipalyed() {
        WaitForElement.waitUntilElementIsVisible(userImage);
        boolean isDisplayed = userImage.isDisplayed();
        logger.info("Returning status of user image after login: {}", isDisplayed);
        return isDisplayed;
    }
}
