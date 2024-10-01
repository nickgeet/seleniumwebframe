package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="input-firstname")
	WebElement firstName;
	@FindBy(id="input-lastname") 
	WebElement lastName;
	@FindBy(id="input-email") 
	WebElement emailID;
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telePhone;
	@FindBy(xpath="//input[@name='password']") 
	WebElement password;
	@FindBy(xpath="//input[@placeholder='Password Confirm']") 
	WebElement cnfPassword;
	@FindBy(xpath="//input[@name='agree']") 
	WebElement policyCheckBox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement register;

public void enterFirstName(String FName) {
	firstName.sendKeys(FName);
}
public void enterLastName(String LName) {
	lastName.sendKeys(LName);
}
public void enterEmail(String email) {
	emailID.sendKeys(email);
}
public void enterTelePhone(String phone) {
	telePhone.sendKeys(phone);
}

public void enterPassword(String pass) {
	password.sendKeys(pass);
}

public void enterCnfPassword(String pass) {
	cnfPassword.sendKeys(pass);
}
public void checkPolicy(){
	if(!policyCheckBox.isSelected()) {
		policyCheckBox.click();
	}
}
public void registerUser() {
	register.click();
}
}