package test_cases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.UserPage;

import java.awt.*;

public class TestCase004_CheckTransactionType extends TestBase{

    UserPage userPage;

    @Test(priority = 5, groups = "smoke", description = "Check Last Transaction Type")
    public void checkTransactionType() throws InterruptedException, AWTException {
        userPage = new pages.UserPage(driver);
        //wait 2 sec
        Thread.sleep(2000);
        userPage.lastTransactonType();
        //wait 2 sec
        Thread.sleep(2000);
        // assert Transaction Page Started Correctly
        PageBase.assertToObjectExistWithGetText(driver, "Transaction Type");
        // assert withdraw type (last transaction)
        Assert.assertEquals(driver.findElements(By.xpath("(//td[@class='ng-binding'])")).get(driver.findElements(By.xpath("(//td[@class='ng-binding'])")).size()-1).getText(),"Debit");
        // take screenshot after successful Deposit
        PageBase.captureScreenshot(driver, "TransactionPage");
        // extend report status
        test.log(LogStatus.PASS, "Check Transaction Type Correctly");
    }
}
