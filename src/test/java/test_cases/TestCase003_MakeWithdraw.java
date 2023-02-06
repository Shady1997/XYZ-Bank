package test_cases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.UserPage;

import java.awt.*;
@Listeners({testNGListener.Listener.class,reports.MyListener.class})
public class TestCase003_MakeWithdraw extends TestBase{
    UserPage userPage;

    @Test(priority = 4, groups = "smoke", description = "Make New Withdraw")
    public void makeNewWithdraw() throws InterruptedException, AWTException {
        userPage = new pages.UserPage(driver);
        userPage.makeWithdraw();
        // assert if successful Withdraw
        PageBase.assertToObjectExistWithGetText(driver, "Transaction successful");
        // assert new balance after Withdraw
        Assert.assertEquals(driver.findElement(By.xpath("(//strong[@class='ng-binding'])[2]")).getText().toString(),"600");
        // take screenshot after successful Withdraw
        PageBase.captureScreenshot(driver, "SuccessfulWithdraw");
        // extend report status
        test.log(LogStatus.PASS, "Create Transaction successfully");
    }
}
