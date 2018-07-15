package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import pages.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void asUserTryToLogInWithCorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        boolean isUserImageIsDipalyed = loginPage
                .typeIntoUserNameField("user@phptravels.com")
                .typeIntoPasswordField("demouser")
                .clickOnLoginButton()
                .isUserImageIsDipalyed();

        assertTrue(isUserImageIsDipalyed);
    }
}
