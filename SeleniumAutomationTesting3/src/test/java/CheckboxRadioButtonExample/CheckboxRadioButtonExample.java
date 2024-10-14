package CheckboxRadioButtonExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckboxRadioButtonExample {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the demo form page
        driver.get("https://demoqa.com/automation-practice-form");

        // Verify the URL to ensure navigation was successful
        String expectedUrl = "https://demoqa.com/automation-practice-form";
        if (driver.getCurrentUrl().equals(expectedUrl)) {
            System.out.println("Navigation to form page successful.");
        } else {
            System.out.println("Navigation failed. Current URL: " + driver.getCurrentUrl());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate and select a specific radio button (e.g., "Male")
            WebElement genderRadioButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Male')]"))
            );
            genderRadioButton.click();

            // Verify if the radio button is selected
            WebElement maleRadioButtonInput = driver.findElement(By.id("gender-radio-1"));
            if (maleRadioButtonInput.isSelected()) {
                System.out.println("Male radio button is selected.");
            } else {
                System.out.println("Failed to select Male radio button.");
            }

            // Locate and select a specific checkbox (e.g., "Sports")
            WebElement sportsCheckbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Sports')]"))
            );
            sportsCheckbox.click();

            // Verify if the checkbox is selected
            WebElement sportsCheckboxInput = driver.findElement(By.id("hobbies-checkbox-1"));
            if (sportsCheckboxInput.isSelected()) {
                System.out.println("Sports checkbox is selected.");
            } else {
                System.out.println("Failed to select Sports checkbox.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
