package NavigationAndSearchExample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationAndSearchExample {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to Wikipedia homepage
            driver.get("https://www.wikipedia.org/");

            // Step 2: Locate and click the "English" link
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement englishLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-link-box-en")));
            englishLink.click();

            // Step 3: Verify that the URL has changed to the English Wikipedia
            String expectedUrl = "https://en.wikipedia.org/wiki/Main_Page";
            wait.until(ExpectedConditions.urlToBe(expectedUrl));  // Ensures navigation to English Wikipedia

            if (driver.getCurrentUrl().equals(expectedUrl)) {
                System.out.println("URL verification successful: " + driver.getCurrentUrl());
            } else {
                System.out.println("URL verification failed. Current URL: " + driver.getCurrentUrl());
            }

            // Step 4: Re-locate the search bar after navigation and perform the search
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
            searchBar.clear();
            searchBar.sendKeys("Selenium (software)", Keys.ENTER); // Enter search term and submit with Enter key

            // Step 5: Verify the search results page loads with the expected term
            String searchUrl = "https://en.wikipedia.org/wiki/Selenium_(software)";
            wait.until(ExpectedConditions.urlToBe(searchUrl));

            if (driver.getCurrentUrl().equals(searchUrl)) {
                System.out.println("Search successful: Navigated to " + driver.getCurrentUrl());
            } else {
                System.out.println("Search failed. Current URL: " + driver.getCurrentUrl());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

