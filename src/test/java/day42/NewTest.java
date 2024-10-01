package day42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
  @Test
  void visit() {
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
  }
  @Test
   void validate() {
//	  WebElement inputField = driver.findElement(By.name("username"));
//	  inputField.sendKeys("Admin");
	  driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@text()='login']")).click();
  }
  @Test
  void close() {
	  driver.close();
  }
}
