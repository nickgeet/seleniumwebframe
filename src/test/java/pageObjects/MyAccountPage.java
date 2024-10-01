package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement btnLogout;
	@FindBy(xpath="//*[text()='Edit your account information']") 
	WebElement editAccountInfo;
	@FindBy(xpath="//*[@name='firstname']") 
	WebElement editFName;
	@FindBy(xpath="//*[@name='lastname']") 
	WebElement editLName;
	@FindBy(xpath="//*[@name='email']") 
	WebElement editEmail ;
	@FindBy(xpath="//*[@name='telephone']") 
	WebElement editTelephone;
	@FindBy(xpath="//*[@type='submit']")
	WebElement updateInfo;
	@FindBy(xpath="//*[text()='Success: Your account has been successfully updated.']") 
	WebElement editSuccessMsg ;
	
	
	
	public boolean validateUserLoggedIn() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickOnLogout() {
		btnLogout.click();
	}
	public void clickOnEditAccount() {
		editAccountInfo.click();
	}
	public void enterFName(String fname) {
		editFName.clear();
		editFName.sendKeys(fname);
	}
	public void enterLName(String lname) {
		editLName.clear();
		editLName.sendKeys(lname);
	}
	public void enterEmail(String email) {
		editEmail.clear();
		editEmail.sendKeys(email);
	}
	public void enterPhone(String phone) {
		editTelephone.clear();
		editTelephone.sendKeys(phone);
	}
	public void clickOnContinue() {
		updateInfo.click();
	}
	public boolean verfiySuccessMsg() {
		return(editSuccessMsg.isDisplayed());
	}
	
}
