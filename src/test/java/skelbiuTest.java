import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class skelbiuTest {
    WebDriver _globalDriver;

    @BeforeTest
    public void setUp() {
        _globalDriver = new ChromeDriver();
        _globalDriver.manage().window().maximize();
    }

    @Test
    public void test1() { // kepure su snapeliu
        int count = 0;
        int a = 0;
        int fakeListings = 0;

        for (int p = 1; p <= 5; p++) {
            _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?keywords=kepure+su+snapeliu");

            if (p == 1) {
                _globalDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
                a += 1;
                if (a != 1) {
                    break;
                }
            }
            for (int i = 1; i <= 27; i++) {
                try {
                    if (_globalDriver.findElement(By.xpath("//*[@id=\"items-list-container\"]/div[" + (p + 1) + "]/div[" + i + "]/a")).getAttribute("class").contains("kainos-item")) {
                        fakeListings++;
                    } else {
                        _globalDriver.findElement(By.xpath("//*[@id=\"items-list-container\"]/div[" + (p + 1) + "]/div[" + i + "]/a")).click();
                        count++;
                        String ID = _globalDriver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]/div[4]/div[1]")).getText();
                        System.out.println(ID);
                    }
                } catch (Exception e) {
                    if (i < 27) {
                        fakeListings++;
                    } else {
                        continue;
                    }
                }
                _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?keywords=kepure+su+snapeliu");
            }
        }

        System.out.println("There are " + count + " real listings.");
        System.out.println("There are " + fakeListings + " fake listings.");
    }

    @Test
    public void samotinesPlytos() { // samotines plytos not working curr
        int count = 0;
        int a = 0;

        for (int p = 1; p <= 5; p++) {
            _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?keywords=samotines+plytos");

            if (p == 1) {
                _globalDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
                a += 1;
                if (a != 1) {
                    break;
                }
            }
            for (int i = 1; i <= 27; i++) {

                try {
                    _globalDriver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div[" + (p + 1) + "]/div[" + i + "]/a")).click();
                    count++;
                } catch (Exception e) {
                    continue;
                }
                String ID = _globalDriver.findElement(By.xpath("//*[@id=\"contentArea\"]/div[6]/div[1]/div[1]/div[4]/div[1]")).getText();
                System.out.println(ID);
                _globalDriver.get("https://www.skelbiu.lt/skelbimai/" + p + "?keywords=samotines+plytos");

            }
        }
        System.out.println("There are " + count + " real listings.");
    }
}
