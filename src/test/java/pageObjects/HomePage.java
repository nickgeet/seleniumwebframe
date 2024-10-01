package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='top-links\']/ul/li[2]/a")
	WebElement myAccount;
	@FindBy(xpath="//*[text()='Register']")
	WebElement registerBtn;
	@FindBy(xpath="//*[text()='Login']")
	WebElement loginBtn;
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	public void clickOnRegister() {
		registerBtn.click();
	}
	public void clickOnLogin() {
		loginBtn.click();
	}
	
	
}
