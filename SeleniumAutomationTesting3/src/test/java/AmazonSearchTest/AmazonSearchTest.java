package AmazonSearchTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonSearchTest {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Specify the search term
        String searchTerm = "Selenium WebDriver";

        try {
            // Step 1: Navigate to Amazon's homepage
            driver.get("https://www.amazon.com");

            // Step 2: Locate the search bar and enter the search term
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            searchBar.sendKeys(searchTerm);

            // Step 3: Click on the search button
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            // Step 4: Verify that search results are displayed and display the search term
            WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 's-main-slot')]")));
            if (results.isDisplayed()) {
                System.out.println("Search results displayed successfully for the term: '" + searchTerm + "'.");
            } else {
                System.out.println("Search results not displayed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
