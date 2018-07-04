package pages;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

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

    public void typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into User Name field {}", username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        logger.info("Typed into Password field {}", password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
        logger.info("Clicked on Login button");
    }

    public String getWaringMessage() {
        WaitForElement.waitUntilElementIsVisible(warningMessage);
        String warningText = warningMessage.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }
}