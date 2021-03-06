package pages;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import java.util.List;

public class HomePage {

    private Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//nav//*[@id='li_myaccount']/a")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//nav//*[@id='li_myaccount']/ul/li/a")
    private List<WebElement> dropDownMenuOptions;

    public HomePage() {
        //Initialization of webelements from HomePage class
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Login link")
    public LoginPage clickOnLoginLink() {
        WaitForElement.waitUntilElementIsClickable(dropDownMenu);
        dropDownMenu.click();

        for(WebElement o: dropDownMenuOptions) {
            if(o.getText().equals("Login")) {
                o.click();
                return new LoginPage();
            }
        }
        logger.info("Clicked on Login link");

        return new LoginPage();
    }

    @Step("Click on SignUp link")
    public SignUpPage clickOnSignUpLink() {
        WaitForElement.waitUntilElementIsClickable(dropDownMenu);
        dropDownMenu.click();

        for(WebElement o: dropDownMenuOptions) {
            if(o.getText().equals("Sign Up")) {
                o.click();
                return new SignUpPage();
            }
        }
        logger.info("Clicked on SignUp link");

        return new SignUpPage();
    }
}
