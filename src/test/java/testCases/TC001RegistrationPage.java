package testCases;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

//import org.apache.commons.lang3.RandomStringUtils;

public class TC001RegistrationPage extends BaseClass {
	@Test(groups={"Sanity", "Master"})
	void executReegistration() {
		
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();
		home.clickOnRegister();
		
		RegistrationPage reg = new RegistrationPage(driver);
		reg.enterFirstName(randomStrFName().toUpperCase());
		reg.enterLastName(randomStrFName().toUpperCase());
		reg.enterEmail(randomStrEmail()+"@yopmail.com");
		reg.enterTelePhone(randomStrPhone());
		reg.enterPassword("Admin123");
		reg.enterCnfPassword("Admin123");
		reg.checkPolicy();
		reg.registerUser();
		
		String Title= driver.getTitle();
		Assert.assertEquals(Title, "Your Account Has Been Created!");
	}
	
	public static String randomStrFName() {
		        String randomStringex = RandomStringUtils.randomAlphabetic(5);  // Generate a 10-character random string
		        //System.out.println(randomStringex);
		        return randomStringex;
		    }
	public static String randomStrLName() {
        String randomStringex = RandomStringUtils.randomAlphabetic(5);  // Generate a 10-character random string
        //System.out.println(randomStringex);
        return randomStringex;
    }
	public static String randomStrEmail() {
        String randomStringex = RandomStringUtils.randomAlphanumeric(3);  // Generate a 10-character random string
        //System.out.println(randomStringex);
        return randomStringex;
    }
	public static String randomStrPhone() {
        String randomStringex = RandomStringUtils.randomNumeric(10);  // Generate a 10-character random string
        //System.out.println(randomStringex);
        return randomStringex;
    }
//	public static String randomStrPassword() {
//        String randomStringex = RandomStringUtils.randomNumeric(10);  // Generate a 10-character random string
//        //System.out.println(randomStringex);
//        return randomStringex;
//    }
}
