package AutomatePageRefresh;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomatePageRefresh {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to Amazon
            driver.get("https://www.amazon.com");

            // Step 2: Create an instance of WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 3: Locate the search bar
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));

            // Verify if the search bar is present
            System.out.println("Before refresh: " + (searchBar.isDisplayed() ? "Search bar is visible." : "Search bar is not visible."));

            // Step 4: Refresh the page
            driver.navigate().refresh();

            // Step 5: Re-locate the search bar after refresh
            searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));

            // Verify if the search bar is still present after the refresh
            System.out.println("After refresh: " + (searchBar.isDisplayed() ? "Search bar is visible." : "Search bar is not visible."));

        } catch (Exception e) {
            System.out.println("An error occurred while checking element visibility.");
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

