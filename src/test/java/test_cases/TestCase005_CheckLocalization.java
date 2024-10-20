package test_cases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestCase005_CheckLocalization {
    // define main properties
    public static WebDriver driver;

    // extend report
    static ExtentTest test;
    static ExtentReports report;
    public static ChromeOptions options;
    JavascriptExecutor js;

//    @BeforeTest
    public void setupDriver() {

        String browser="chrome";
//
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        // to run headless test
//		options.addArguments("--headless");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        if (browser.equalsIgnoreCase("Firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + prop.getProperty("firefoxdriver"));
            // use webdrivermanager
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + prop.getProperty("chromedriver"));
            // use webdrivermanager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser value!!");
            // Change thread count 1 for sequential , 2 for parallel 3 ..browser..
        }

        js = (JavascriptExecutor) driver;
        // Set Driver wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // define extend report
        report = new ExtentReports(System.getProperty("user.dir") + "/index1.html");
        test = report.startTest("XYZ Project");
    }

    @Test(priority = 1, groups = "smoke", description = "Start XYZ-Bank Web Application")
    public void startApplication() throws InterruptedException, IOException, ParseException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Mazimize current window
        driver.manage().window().maximize();
        // handel localization testing in selenium 4
        DevTools devTools=((HasDevTools) driver).getDevTools();
        devTools.createSession();

        Map<String , Object> coordinates=new HashMap<String , Object>();
        coordinates.put("latitute","40");
        coordinates.put("longtitute","3");
        coordinates.put("accuracy","1");

//        ((HasCdp) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://www.facebook.com");
        driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

        String title=driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);

    }

    @AfterTest
    public void tearDown() {
        report.endTest(test);
        report.flush();
        driver.quit();
    }

}
