package test_cases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.UserPage;

import java.awt.*;

public class TestCase002_MakeDeposite extends TestBase{

    UserPage userPage;

    @Test(priority = 3, groups = "smoke", description = "Make New Deposite")
    public void makeNewDeposite() throws InterruptedException, AWTException {
        userPage = new pages.UserPage(driver);
        userPage.makeDeposite();
        // assert Successful Deposit
        PageBase.assertToObjectExistWithGetText(driver, "Deposit Successful");
        // assert new balance after deposite
        Assert.assertEquals(driver.findElement(By.xpath("(//strong[@class='ng-binding'])[2]")).getText().toString(),"1000");
        // take screenshot after successful Deposit
        PageBase.captureScreenshot(driver, "SuccessfulDeposite");
        // extend report status
        test.log(LogStatus.PASS, "Create Deposit Successfully");
    }
}
