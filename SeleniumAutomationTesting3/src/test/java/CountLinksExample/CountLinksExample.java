package CountLinksExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountLinksExample {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Navigate to the Wikipedia homepage
            driver.get("https://en.wikipedia.org/wiki/Main_Page");

            // Step 2: Locate all <a> elements (links) on the page
            List<WebElement> links = driver.findElements(By.tagName("a"));

            // Step 3: Count the number of links
            int linkCount = links.size();
            System.out.println("Total number of links on the page: " + linkCount);

            // Optional: Print out the text of each link
            for (WebElement link : links) {
                System.out.println(link.getText());
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
