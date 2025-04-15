package selenum.seleniumDemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    @SuppressWarnings("unused")
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout
    }

    private By emailField = By.id("username");
    private By passwordField = By.id("password");
    private By loginToSandBox = By.id("Login");
    private By searchBox = By.xpath("//input[@placeholder='Search Setup']");

    // Methods
    public void enterUsername(String username) {
        System.out.println("Entering username: " + username);
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.sendKeys(username);
        System.out.println("Username entered successfully.");
    }

    public void enterPassword(String password) {
        System.out.println("Entering password: " + password);
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
        System.out.println("Password entered successfully.");
    }

    public void clickLogin() throws InterruptedException {
        System.out.println("Clicking login button...");
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginToSandBox));
        loginBtn.click();
        System.out.println("Login button clicked successfully.");
        Thread.sleep(10000);

        // ✅ Wait for full page load
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

    public void searchLogin() {

       WebElement searchBox = driver.findElement(By.xpath("//button[@type='button']"));
       searchBox.click();
        System.out.println("Search Button Clicked successfully");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}