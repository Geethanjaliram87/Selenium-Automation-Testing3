package ElementVisibilityTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementVisibilityTest {
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

            // Step 3: Locate the search bar using its name
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));

            // Step 4: Verify if the search bar is visible
            if (searchBar.isDisplayed()) {
                System.out.println("The search bar is visible on the page.");
            } else {
                System.out.println("The search bar is not visible on the page.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred while checking element visibility.");
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
