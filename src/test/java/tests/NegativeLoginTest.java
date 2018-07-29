package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class NegativeLoginTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The scope of this test is to login using incorrect username and password" +
                 "and check if warning message is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("")
                .typeIntoPasswordField("")
                .clickOnLoginButton();
        loginPage.assertThatWarningMessageIsDisplayed("Invalid Email or Password");
    }
}
