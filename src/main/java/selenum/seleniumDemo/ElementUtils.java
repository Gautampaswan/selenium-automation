package selenum.seleniumDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    public static WebElement waitAndScrollToElement(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            System.out.println("🔍 Waiting for element: " + locator.toString());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

            // Step 1: Wait for element to be present in DOM
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("✅ Element present in DOM.");

            // Step 2: Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("📜 Scrolled to element.");

            // Step 3: Wait for visibility
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("👁️ Element is visible.");

            // Step 4: Wait for clickability
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("🖱️ Element is clickable.");

            return element;

        } catch (TimeoutException e) {
            System.out.println("⏱️ TimeoutException: Element not found within " + timeoutInSeconds + " seconds: " + locator);
        } catch (NoSuchElementException e) {
            System.out.println("❌ NoSuchElementException: Element not found: " + locator);
        } catch (Exception e) {
            System.out.println("⚠️ Exception while waiting for element: " + locator);
            e.printStackTrace();
        }

        return null;
    }
}

