package HandlingDisabledButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingDisabledButton {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to the demo form website
            driver.get("https://demoqa.com/automation-practice-form");

            // Step 2: Wait for the submit button to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

            // Step 3: Verify if the button is disabled
            boolean isButtonEnabled = submitButton.isEnabled();

            // Print the result
            if (!isButtonEnabled) {
                System.out.println("The submit button is disabled as expected.");
            } else {
                System.out.println("The submit button is enabled, which is not expected.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the button state.");
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
