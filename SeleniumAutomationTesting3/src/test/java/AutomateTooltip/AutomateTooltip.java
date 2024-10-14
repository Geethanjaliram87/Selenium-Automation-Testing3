package AutomateTooltip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomateTooltip {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to the jQuery UI tooltip demo page
            driver.get("https://jqueryui.com/tooltip/");

            // Switch to the frame that contains the tooltip example
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

            // Step 2: Find the element that triggers the tooltip
            WebElement tooltipTrigger = driver.findElement(By.id("age"));

            // Step 3: Use ActionChains to hover over the element
            Actions actions = new Actions(driver);
            actions.moveToElement(tooltipTrigger).perform();

            // Step 4: Wait for the tooltip to appear and verify the tooltip text
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-tooltip-content")));

            // Step 5: Get and verify the tooltip text
            String tooltipText = tooltip.getText();
            System.out.println("Tooltip text: " + tooltipText);

            // Verify the expected tooltip text
            if (tooltipText.equals("We ask for your age only for statistical purposes.")) {
                System.out.println("Tooltip text is as expected.");
            } else {
                System.out.println("Tooltip text is not as expected.");
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
