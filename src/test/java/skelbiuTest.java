import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class skelbiuTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void test1() {

        driver.get("https://www.skelbiu.lt"); // opening the page
        driver.manage().window().maximize(); // maximising the page
        driver.findElement(By.id("onetrust-accept-btn-handler")).click(); // accepting cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("searchKeyword")).sendKeys("traktorius 22kw"); // searching for the prompt
        driver.findElement(By.id("searchButton")).click(); // clicking the search button

        WebElement countWE = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/ul/li/span")); // finding the number of listings
        String countText = countWE.getText(); // converting the webelement to string
        countText = countText.replaceAll("[^0-9]", ""); // replacing all additional unusable characters '()'
        int listingCount = Integer.parseInt(countText); // converting the String to int

//        driver.wait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='some_input'][contains(@style, 'display: block')]")));
       driver.close(); // closing the browser
    }
}
