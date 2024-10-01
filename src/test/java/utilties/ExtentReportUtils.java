package utilties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils extends BaseClass implements ITestListener  {
	private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;

    // Set up the reporting environment
    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Report-" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Functional Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
//        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
     // Get browser details and set them as system info
//        if (driver != null) {
//        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//        String browserName = caps.getBrowserName();
//        //String browserVersion = caps.getVersion(); // Or caps.getCapability("version")
//        Object browserVersion = caps.getCapability("version");
//        extent.setSystemInfo("Browser", browserName );
//        extent.setSystemInfo("Browser Version", browserVersion.toString());
//        }
//        else {
//            System.out.println("WebDriver is null. Cannot retrieve browser details.");
//        }

        // System Info
        extent.setSystemInfo("Host Name", "LocalHost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("New Name", "Test");

    }

    // Log test start
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.assignCategory(result.getMethod().getGroups()); // For grouping tests
    
    if (driver != null) {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        //String browserVersion = caps.getVersion(); // Or caps.getCapability("version")
        String browserVersion = caps.getBrowserVersion();
        extent.setSystemInfo("Browser", browserName );
        extent.setSystemInfo("Browser Version", browserVersion);
        }
        else {
            System.out.println("WebDriver is null. Cannot retrieve browser details.");
        }
    }

    // Log test success
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    // Log test failure and capture screenshots
    @Override
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Error: " + result.getThrowable());

        // Capture screenshot on failure
        if (driver != null) {
            String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
            try {
                test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot to the report
            } catch (Exception e) {
                test.log(Status.WARNING, "Failed to attach screenshot");
            }
        }
    }

    // Log test skip
    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    // Log test completion and calculate execution time
    @Override
    public void onTestFinish(ITestResult result) {
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        test.log(Status.INFO, "Test duration: " + duration + " seconds");
    }

    // Log test suite completion
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Helper method to capture screenshots
    public String captureScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    // Set WebDriver for screenshots
//    public void setDriver(WebDriver driver) {
//    	ExtentReportUtils.driver = driver;
//        //this.driver = driver;
//    }
}