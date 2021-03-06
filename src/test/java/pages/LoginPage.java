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

public class LoginPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"loginfrm\"]/div[1]/div[5]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"loginfrm\"]/div[1]/div[2]/div")
    private WebElement warningMessage;

    public LoginPage() {
        //Initialization of webelements from LoginPage class
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into User Name field {}", username);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        logger.info("Typed into Password field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public UserAccountPage clickOnLoginButton() {
        loginButton.click();
        logger.info("Clicked on Login button");
        return new UserAccountPage();
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningMessageIsDisplayed(String message) {
        logger.info("Checking if warning message {} is displayed", message);
        WaitForElement.waitUntilElementIsVisible(warningMessage);
        AssertWebElement.assertThat(warningMessage).isDisplayed().hasText(message);
        return this;
    }
}
