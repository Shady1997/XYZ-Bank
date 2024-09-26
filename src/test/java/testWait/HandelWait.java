package testWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HandelWait {
    @Test
    public void handelWait() {
        // use web driver manager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        //expected condition presenceOfNestedElementsLocatedBy on options
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            w.until(ExpectedConditions
                    .presenceOfNestedElementsLocatedBy
                            (By.xpath("//select[@name='continents']"), By.tagName("option")));
            // identify dropdown
            WebElement l = driver.findElement(By.xpath("//select[@name='continents']"));
            // select option by Select class
            Select s = new Select(l);
            // selectByVisibleText to choose an option
            s.selectByVisibleText("Africa");
        }
        catch(Exception e) {
            System.out.println("Options not available");
        }
        driver.quit();
    }
}
