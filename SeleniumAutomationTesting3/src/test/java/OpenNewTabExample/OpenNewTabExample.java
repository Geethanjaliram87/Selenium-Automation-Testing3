package OpenNewTabExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenNewTabExample {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String originalWindow = null;

        try {
            // Step 1: Navigate to the Wikipedia homepage
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            // Step 2: Find the link that opens in a new tab
            WebElement link = driver.findElement(By.linkText("Wikimedia Foundation"));
            link.click(); // Click the link to open in a new tab

            // Step 3: Get the current window handle
            originalWindow = driver.getWindowHandle();

            // Step 4: Switch to the new tab
            List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
            for (String windowHandle : windowHandles) {
                if (!originalWindow.equals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Step 5: Verify the content of the new tab
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated to use Duration
            wait.until(ExpectedConditions.titleContains("Wikimedia Foundation"));

            String pageTitle = driver.getTitle();
            System.out.println("New tab title: " + pageTitle);

            // Verify the content
            if (pageTitle.contains("Wikimedia Foundation")) {
                System.out.println("Successfully switched to the new tab with correct content.");
            } else {
                System.out.println("The content of the new tab is not as expected.");
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
