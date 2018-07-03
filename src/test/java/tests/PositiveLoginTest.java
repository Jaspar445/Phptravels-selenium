package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTest extends BaseTest {

    @Test
    public void asUserTryToLogInWithCorrectLoginAndPassword() {
        HomePage homePage = new HomePage();
        homePage.clickOnMyAccountDropMenuAndSelectOption("Login");

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("user@phptravels.com");
        loginPage.typeIntoPasswordField("demouser");
        loginPage.clickOnLoginButton();

        UserAccountPage userAccountPage = new UserAccountPage();

        assertTrue(userAccountPage.isUserImageIsDipalyed());
    }
}
