package InteractWithHiddenElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InteractWithHiddenElements {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to the W3Schools Toggle Hide and Show page
            driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

            // Step 2: Find the button that toggles the hidden content
            WebElement toggleButton = driver.findElement(By.xpath("//*[@id='main']/button"));

            // Step 3: Click the toggle button to reveal the hidden content
            toggleButton.click();

            // Step 4: Wait for a short duration to allow the content to be toggled
            Thread.sleep(1000); // Wait for 1 second (adjust this if needed)

            // Step 5: Check if the hidden content is present in the DOM
            WebElement hiddenContent = driver.findElement(By.id("myDIV"));

            // Step 6: Use JavaScript to check if the element is visible
            boolean isDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].offsetParent !== null;", hiddenContent);

            // Step 7: Verify that the hidden content is displayed
            if (isDisplayed) {
                System.out.println("The hidden content is now displayed: " + hiddenContent.getText());
            } else {
                System.out.println("The hidden content is not displayed.");
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
