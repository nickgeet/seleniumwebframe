package testBase;

import java.io.FileReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import utilties.ExtentReportUtils;



public class BaseClass {
	public Properties p; // we have to a property class in order to read the file data
	//public Logger logger;
	public static WebDriver driver;
	
	@BeforeClass(groups = {"Sanity", "Regression", "Master"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException {
		
		//logger=LogManager.getLogger(this.getClass());
		
		FileReader file = new FileReader("./src//test//resources//config.properties");//this is getting the file path
		p = new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome":driver = new ChromeDriver(); break;
		case "edge":driver = new EdgeDriver(); break;
		case "firefox":driver = new FirefoxDriver(); break;
		default: System.out.println("Enter correct browser name"); return;//to exist from whole process it not going to execute the next method
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); // reading url from properties
		driver.manage().window().maximize();
//		ExtentReportUtils extent = new ExtentReportUtils();
//		extent.setDriver(driver);
		// Pass WebDriver instance to ExtentReportUtils
//        ExtentReportUtils reportUtils = new ExtentReportUtils();
//        reportUtils.setDriver(driver);
	}
	
	@AfterClass(groups= {"Sanity", "Regression", "Master"})
	public void tearDown() {
		driver.quit();
		}

	public void onTestFinish(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
