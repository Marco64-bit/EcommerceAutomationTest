package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Selenium 4 automatically handles the edgedriver.exe setup!
        driver = new EdgeDriver();

        // Maximize window and set a default wait time so scripts don't fail if the site is slow
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target website
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test is done
        if (driver != null) {
            driver.quit();
        }
    }
}