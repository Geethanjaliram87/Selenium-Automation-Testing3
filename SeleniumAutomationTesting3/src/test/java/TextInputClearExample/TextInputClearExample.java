package TextInputClearExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextInputClearExample {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to a webpage with an input field (W3Schools HTML form example)
            driver.get("https://www.w3schools.com/html/html_forms.asp");

            // Step 2: Locate the input field (e.g., "First name")
            WebElement inputField = driver.findElement(By.id("fname"));

            // Step 3: Enter text into the input field
            String textToEnter = " Selenium Test";
            inputField.sendKeys(textToEnter);
            System.out.println("Entered text: " + inputField.getAttribute("value"));

            // Step 4: Clear the input field
            inputField.clear();
            System.out.println("Text after clearing: " + inputField.getAttribute("value"));

            // Step 5: Verify that the field is empty
            if (inputField.getAttribute("value").isEmpty()) {
                System.out.println("Field is empty after clearing.");
            } else {
                System.out.println("Field is not empty after clearing.");
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
