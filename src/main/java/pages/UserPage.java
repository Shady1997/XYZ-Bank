package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    private WebElement depositeButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement withdrawButton;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement transactionButton;

    @FindBy(xpath = "(//td[@class='ng-binding'])")
    public WebElement lastTransactionType;

    @FindBy(xpath = "//input[@ng-model='amount']")
    private WebElement inputAmount;

    @FindBy(xpath = "//button[text()='Deposit']")
    private WebElement makeDepositButton;

    @FindBy(xpath = "//button[text()='Withdraw']")
    private WebElement makeWithdrawButton;

    // TODO: add new deposite
    public void makeDeposite(){
        // Step 1: choose deposite button
        depositeButton.click();
        // Step 2: add 1000
        inputAmount.sendKeys("1000");
        // Step 3: make deposite
        makeDepositButton.click();
    }

    // TODO: add new Withdraw
    public void makeWithdraw() throws InterruptedException {
        // Step 1: choose withdraw
        withdrawButton.click();
        // wait 2 sec
        Thread.sleep(2000);
        // Step 2: add amount
        inputAmount.sendKeys("400");
        // Step 3: make withdraw
        makeWithdrawButton.click();
    }
    // TODO: Check Transaction Type of last transaction
    public void lastTransactonType(){
        // Step 1: click transaction button
        transactionButton.click();
    }
}
