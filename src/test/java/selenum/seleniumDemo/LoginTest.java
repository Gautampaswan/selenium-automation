package selenum.seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        test = extent.createTest("Login Test", "Verify user can log in");

        LoginPage loginPage = new LoginPage(driver);

        test.info("Entering username");
        loginPage.enterUsername("bhuguser@cynoteck.com.bhugsit");

        test.info("Entering password");
        loginPage.enterPassword("Bhugprod@123");

        test.info("Clicking login");
        loginPage.clickLogin();
        test.pass("Login successful");
        loginPage.searchLogin();
        test.pass("Search Button Clicked successfully");
    }
}
