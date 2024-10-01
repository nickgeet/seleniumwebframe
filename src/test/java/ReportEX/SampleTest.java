package ReportEX;

import java.time.Duration;

//import ReportEx.ExtentReportUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Initialize Extent Report
        ExtentReportUtil.initExtentReport("Sample Test Report");
    }

    @Test
    public void testExample() {
        ExtentReportUtil.createTest("Example Test");
        
        // Perform test steps
//        driver.get("https://www.example.com");
        ExtentReportUtil.logInfo("Navigated to Example website");
        String title = driver.getTitle();
        if (title.equals("OrangeHRM")) {
            ExtentReportUtil.logPass("Title is as expected.");
        } else {
            try {
                ExtentReportUtil.logFail("Title is not as expected.", driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        // Quit driver
        if (driver != null) {
            driver.quit();
        }

        // Flush the report
        ExtentReportUtil.flushReport();
    }
}

