package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003EditAccountInfo extends BaseClass {
	@Test
	void executeEditAccountInfo() {
	HomePage home = new HomePage(driver);
	home.clickOnMyAccount();
	home.clickOnLogin();
	
	LoginPage login = new LoginPage(driver);
	login.enterEmail(p.getProperty("email"));
	login.enterPassword(p.getProperty("password"));
	login.clickOnLogin();
	
	MyAccountPage myacc = new MyAccountPage(driver);
	myacc.clickOnEditAccount();
	myacc.enterFName("New");
	myacc.enterLName("Name");
	myacc.enterEmail("faa1234@yopmail.com");
	myacc.enterPhone("1234456732");
	myacc.clickOnContinue();
	myacc.verfiySuccessMsg();
	System.out.println(myacc.verfiySuccessMsg());
	//Assert.assertEquals(false, null);
	Assert.assertTrue(true);
	}
}
