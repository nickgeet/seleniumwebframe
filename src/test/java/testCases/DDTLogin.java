package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilties.ExcelUtils;

public class DDTLogin extends BaseClass{
	
	    @DataProvider(name = "testData")
	    public Object[][] getData() throws Exception {
	        String excelPath = "C:\\Users\\91828\\eclipse-workspace\\seleniumwebd\\testdata\\LoginTestData.xlsx";
	        String sheetName = "Sheet1"; // Your Excel sheet name
	        return ExcelUtils.getTestData(excelPath, sheetName);
	    }

	    @Test(dataProvider = "testData")
	    public void testLogin(String username, String password, String Validation) {
	        System.out.println("Username: " + username + " | Password: " + password+ "| Validation:"+ Validation);
	        // Add your test logic here
	        try
	        {
	        HomePage home = new HomePage(driver);
			home.clickOnMyAccount();
			home.clickOnLogin();
			Thread.sleep(5000);
			LoginPage login = new LoginPage(driver);
			login.enterEmail(username);
			login.enterPassword(password);
			login.clickOnLogin();
			if(Validation.equals("valid")) {
				System.out.println("Login Successful");
				Assert.assertEquals(driver.getTitle(), "My Account");
			}
			else {
				System.out.println("Login Failed");
				//Assert.assertNotEquals(driver.getTitle(), "Your Store");
			}
			//Assert.assertEquals(driver.getTitle(), "My Account");
	        }
	        catch(Exception e) {
	        	Assert.fail();
	        }
	    }
	    

}
