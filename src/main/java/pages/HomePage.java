package pages;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Customer Login']")
	private WebElement customerLogin;

	@FindBy(xpath = "//button[text()='Bank Manager Login']")
	private WebElement bankManagerLogin;

	@FindBy(id = "userSelect")
	private WebElement selectName;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public void loginToXYZBank() {
		// TODO: Choose customer login and username then login to application
		// Step 1: choose customer login
		customerLogin.click();
		// Step 2: choose customer name
		Select chooseCustomerName=new Select(selectName);
		chooseCustomerName.selectByIndex(4);
		// Step 3: click login button
		loginButton.click();
	}

}
