package Newprac;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("testing,,,,");
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		String title = driver.getTitle();
		if(title.equals("Your Store")){
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title not matched");
		}
		driver.quit();
	}

}
