package ExtractTextExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtractTextExample {
    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the Wikipedia Selenium article page
        driver.get("https://en.wikipedia.org/wiki/Selenium_(software)");

        try {
            // Locate the first paragraph in the "Selenium" article
            WebElement firstParagraph = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/p[2]"));

            // Extract and print the paragraph text to the console
            System.out.println("First paragraph of Selenium article:");
            // Extract the paragraph text
            String paragraphText = firstParagraph.getText();

            // Display the paragraph in 2-3 line chunks for readability
            int charLimit = 80;  // Adjust this value as needed for line length
            for (int i = 0; i < paragraphText.length(); i += charLimit) {
                int end = Math.min(paragraphText.length(), i + charLimit);
                System.out.println(paragraphText.substring(i, end));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
