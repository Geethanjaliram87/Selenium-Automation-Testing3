package BrowserNavigationExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigationExample {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to the first page (e.g., Wikipedia)
            driver.get("https://en.wikipedia.org/wiki/Main_Page");
            System.out.println("Initial page title: " + driver.getTitle());

            // Step 2: Locate the "Current events" link using a CSS selector and click it
            WebElement link = driver.findElement(By.cssSelector("a[title='Portal:Current events']"));
            link.click();
            System.out.println("New page title after clicking link: " + driver.getTitle());

            // Step 3: Use the browser's back button
            driver.navigate().back();
            System.out.println("Page title after navigating back: " + driver.getTitle());

            // Step 4: Use the browser's forward button
            driver.navigate().forward();
            System.out.println("Page title after navigating forward: " + driver.getTitle());

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
