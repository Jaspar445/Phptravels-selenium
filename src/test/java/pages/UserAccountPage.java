package pages;

import driver.manager.DriverManager;
import genericAssertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class UserAccountPage {

    private Logger logger = LogManager.getLogger(UserAccountPage.class);

    @FindBy(xpath = "//*[@id=\"body-section\"]/div/div[1]/div/div/div/img")
    private WebElement userImage;

    public UserAccountPage() {
        //Initialization of webelements from UserAccountPage class
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Assert that user image is displayed")
    public UserAccountPage assertThatUserImageIsDisplayed() {
        logger.info("Checking if user image is displayed");
        WaitForElement.waitUntilElementIsVisible(userImage);
        AssertWebElement.assertThat(userImage).isDisplayed();
        return this;
    }
}
