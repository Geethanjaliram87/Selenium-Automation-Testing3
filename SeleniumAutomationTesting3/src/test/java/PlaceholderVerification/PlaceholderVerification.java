package PlaceholderVerification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceholderVerification {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to the new website with the input field
            driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");

            // Step 2: Wait for the input field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));

            // Step 3: Retrieve and verify the placeholder text
            String expectedPlaceholder = "Name"; // Expected placeholder text
            String actualPlaceholder = inputField.getAttribute("placeholder");

            // Step 4: Check if the actual placeholder matches the expected placeholder
            if (actualPlaceholder != null && actualPlaceholder.equals(expectedPlaceholder)) {
                System.out.println("Placeholder text is as expected: " + actualPlaceholder);
            } else {
                System.out.println("Placeholder text is not as expected. Found: " + actualPlaceholder);
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
