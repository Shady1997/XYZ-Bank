package test_cases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PageBase;

public class TestCase001_CustomerLogin extends TestBase {

	HomePage homePage;

	@Test(priority = 2, groups = "smoke", description = "Customer Login")
	public void customerLogin() {
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
