package FormValidationExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormValidationExample {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the SauceDemo login page
            driver.get("https://www.saucedemo.com/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate the "Login" button and attempt to click it without entering Username and Password
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Wait for the error message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

            // Verify and print the error message text
            String errorText = errorMessage.getText();
            System.out.println("Validation error displayed: " + errorText);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
