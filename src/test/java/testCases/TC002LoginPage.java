package testCases;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002LoginPage extends BaseClass{
	@Test(groups={"Regression","Master"})
	void PerformLoginTest() {
//		HomePage home = new HomePage(driver);
//		home.clickOnMyAccount();
//		home.clickOnLogin();
//		LoginPage login = new LoginPage(driver);
//		login.enterEmail(p.getProperty("email"));
//		login.enterPassword(p.getProperty("password"));
//		login.clickOnLogin();
		
//		Assert.assertEquals(driver.getTitle(), "My Account");
		try {
			HomePage home = new HomePage(driver);
			home.clickOnMyAccount();
			home.clickOnLogin();
			
			LoginPage login = new LoginPage(driver);
			login.enterEmail(p.getProperty("email"));
			login.enterPassword(p.getProperty("password"));
			login.clickOnLogin();
			Assert.assertEquals(driver.getTitle(), "My Account");
		}
		catch(Exception e) {
			Assert.fail();
			}
		
		
	}

}
