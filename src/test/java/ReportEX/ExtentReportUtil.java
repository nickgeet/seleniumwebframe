package ReportEX;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportUtil {

    private static ExtentReports extent;
    private static ExtentTest test;
    //private static WebDriver driver;

    // Method to initialize the Extent Report
    public static ExtentReports initExtentReport(String reportName) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time stamp
        String reportPath = System.getProperty("user.dir") + "/Reports/" + reportName + "_" + timeStamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Extent Report for Automation Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Nick");
        
        //ITestContext  testContext;
//        String browser = testContext.getCurrentXmlTest().getParameter("browser");
//        extent.setSystemInfo("Browser", browser);
//        
//        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
//        if(!includedGroups.isEmpty()) {
//            extent.setSystemInfo("Groups", includedGroups.toString());
//        }

        return extent;
        
    }
    

    // Method to start test case in the report
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    // Method to log information in the report
    public static void logInfo(String message) {
        test.info(message);
    }

    // Method to log passed status in the report
    public static void logPass(String message) {
        test.pass(message);
    }

    // Method to log failed status in the report with screenshot
    public static void logFail(String message, WebDriver driver) throws IOException {
        test.fail(message);
        test.addScreenCaptureFromPath(captureScreenshot(driver));
    }

    // Method to capture screenshot
    public static String captureScreenshot(WebDriver driver) throws IOException {
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/";
        String screenshotName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File(screenshotPath + screenshotName));
        return screenshotPath + screenshotName;
    }

    // Method to flush the extent report
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
