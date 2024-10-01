package ReportEX;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Titleverf {
	WebDriver driver;
	
	public Titleverf(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//By usernameField = By.id("username");
//    By passwordField = By.id("password");
//    By loginButton = By.id("loginButton");
//    By errorMessage = By.id("errorMessage");
	
	@FindBy(xpath="//wdsfdfdf") WebElement userName;
    
    public void mainPage(String username) {
    	userName.sendKeys(username);
		//return null;
    }

}


