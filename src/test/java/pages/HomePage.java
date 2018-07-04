package pages;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import java.util.List;

public class HomePage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//nav//*[@id='li_myaccount']/a")
    private WebElement dropDownMenu;

    public HomePage() {
        //Initialization of webelements from HomePage class
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnMyAccountDropMenuAndSelectOption(String option) {
        WaitForElement.waitUntilElementIsClickable(dropDownMenu);
        dropDownMenu.click();

        List<WebElement> options = DriverManager.getWebDriver().findElements(By.xpath("//nav//*[@id='li_myaccount']/ul/li/a"));

        for(WebElement o: options) {
            if(o.getText().equals(option)) {
                o.click();
                return;
            }
        }
        logger.info("Clicked on Login link");
    }
}
