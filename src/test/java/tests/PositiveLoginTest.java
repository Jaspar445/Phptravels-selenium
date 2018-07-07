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
        boolean isUserImageIsDipalyed = homePage
                .clickOnLoginLink()
                .typeIntoUserNameField("user@phptravels.com")
                .typeIntoPasswordField("demouser")
                .clickOnLoginButton()
                .isUserImageIsDipalyed();

        assertTrue(isUserImageIsDipalyed);
    }
}
