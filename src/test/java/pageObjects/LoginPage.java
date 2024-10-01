package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver  driver){
		super(driver);
	}
	
	@FindBy(xpath="//*[@name='email']")
	WebElement txtFieldEmail;
	@FindBy(xpath="//*[@name='password']")
	WebElement txtFieldPasssword;
	@FindBy(xpath="//*[@value='Login']")
	WebElement btnLogin;
	
	public void enterEmail(String email) {
		txtFieldEmail.sendKeys(email);
	}
	public void enterPassword(String paswword) {
		txtFieldPasssword.sendKeys(paswword);
	}
	public void clickOnLogin() {
		btnLogin.click();;
	}
	
	
	

}
