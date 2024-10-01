package day43;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadriven {
	WebDriver driver;
	@BeforeClass
	  void Go() {
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
		  
	  }
	  @Test(dataProvider="dp")
	   void validate(String email, String pwd) {
//		  WebElement inputField = driver.findElement(By.name("username"));
//		  inputField.sendKeys("Admin");
		  driver.findElement(By.xpath("//*[@name='username']")).sendKeys(email);
		  driver.findElement(By.name("password")).sendKeys(pwd);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
	  }
	  @AfterClass
	  void close() {
//		  driver.findElement(By.xpath("//*[@class='oxd-userdropdown-tab']//i")).click();
		  driver.close();
	  }
		  
	  
	  @DataProvider(name="dp", indices= {0,1,2})
	  Object[][] logindata() {
		  Object[][] data = {
				  {"abc@gmail.com", "admin123"},
				  {"abc12@gmail.com", "admin123"},
				  {"Admin", "admin123"},
				  {"abc212@gmail.com", "admin123"},
				  };
		  return data;
	  }
	  

}
