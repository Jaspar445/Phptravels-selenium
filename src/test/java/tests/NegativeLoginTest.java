package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import pages.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("")
                .typeIntoPasswordField("")
                .clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid Email or Password");
    }
}
