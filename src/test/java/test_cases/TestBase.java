package test_cases;

//import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
		import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


@Listeners({testNGListener.Listener.class,reports.MyListener.class})
public class TestBase {

	// define main properties
	public static WebDriver driver;
//	FileInputStream readProperty;
//	public static Properties prop;

	// extend report
	static ExtentTest test;
	static ExtentReports report;
	public static ChromeOptions options;
	JavascriptExecutor js;

	@Parameters("browser")
	@BeforeTest
	public void setupDriver(String browser){
//		readProperty = new FileInputStream(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\generalProperties.properties");
//		prop = new Properties();
//		prop.load(readProperty);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--remote-allow-origins=*");
		// to run headless test
		options.addArguments("--headless");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

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
			driver = new ChromeDriver(options);
		} else {
			throw new IllegalArgumentException("Invalid browser value!!");
			// Change thread count 1 for sequential , 2 for parallel 3 ..browser..
		}

		js = (JavascriptExecutor) driver;
		// Set Driver wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// define extend report
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("XYZ Project");
	}

	@Test(priority = 1, groups = "smoke", description = "Start XYZ-Bank Web Application")
	public void startApplication() throws InterruptedException, IOException, ParseException {
		// Mazimize current window
		driver.manage().window().maximize();
		// navigate to website
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		// take screenshot to login page
//		PageBase.captureScreenshot(driver, "HomePage");
//		// assert if application start correctly
//		PageBase.assertToObjectExistWithGetText(driver, "XYZ Bank");

//		// handle json data
//		JSONParser jsonParser= new JSONParser();
//		FileReader fileReader = new FileReader("src/Jsonfiles/employee.json");
//         //Read Json file
//		Object obj = jsonParser.parse(fileReader);
//		JSONObject jsonObject = (JSONObject)obj;
//		//Print JSON file
//		System.out.println(jsonObject);
//		for (int i =0;i<array.size();i++){
//			JSONObject address = (JSONObject) array.get(i);
//
//			String street = (String) address.get("street");
//			String city = (String) address.get("city");
//			String state = (String) address.get("state");
//
//			System.out.println("STREET  "+street);
//			System.out.println("CITY  "+city);
//			System.out.println("STATE  "+state);
//		}

	}

	@AfterTest
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
