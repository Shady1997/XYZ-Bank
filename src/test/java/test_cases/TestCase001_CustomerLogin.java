package test_cases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.PageBase;

public class TestCase001_CustomerLogin extends TestBase {

	pages.HomePage homePage;

	@Test(priority = 2, groups = "smoke", description = "Customer Login")
	public void customerLogin() throws InterruptedException, AWTException {
		homePage = new pages.HomePage(driver);
		homePage.loginToXYZBank();
		// take screenshot after successful login
		PageBase.captureScreenshot(driver, "LoginPage");
		// assert if login correctly
//		PageBase.assertToObjectExistWithGetText(driver, " Welcome ");
	}

}
