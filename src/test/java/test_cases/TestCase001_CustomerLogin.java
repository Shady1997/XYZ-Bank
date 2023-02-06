package test_cases;

import java.awt.AWTException;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.PageBase;

@Listeners({testNGListener.Listener.class,reports.MyListener.class})
public class TestCase001_CustomerLogin extends TestBase {

	pages.HomePage homePage;

	@Test(priority = 2, groups = "smoke", description = "Customer Login")
	public void customerLogin() throws InterruptedException, AWTException {
		homePage = new pages.HomePage(driver);
		homePage.loginToXYZBank();
		// take screenshot after successful login
		PageBase.captureScreenshot(driver, "LoginPage");
		// assert if login correctly
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='borderM box padT20 ng-scope'] div:nth-child(1) strong:nth-child(1)")).getText().toString(), "Welcome Albus Dumbledore !!");
		PageBase.assertToObjectExistWithGetText(driver, " Welcome ");
		// extend report status
		test.log(LogStatus.PASS, "Login Correctly to XYZ Bank");
	}

}
