package selenum.seleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.AfterClass;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    private WebDriverWait wait;

    protected ExtentTest test;


    @BeforeClass
    public void setUp() {
        extent = ExtentReportManager.getReporter();

        System.setProperty("web driver.chrome.driver",
                "D:/SeleniumAutomation/seleniumDemo/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Disable browser notification popups
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://test.salesforce.com/");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
            extent.flush();
        }
    }
}
