package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The scope of this test is to login using correct username and password" +
                 "and check if user image is displayed")
    public void asUserTryToLogInWithCorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("user@phptravels.com")
                .typeIntoPasswordField("demouser")
                .clickOnLoginButton()
                .assertThatUserImageIsDisplayed();
    }
}
