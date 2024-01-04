package com.jkyog.automation.base;


import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.utilities.DriversPath;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    private static String tcName;
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static String imagePath;

    @Parameters({"browser"})
    @BeforeSuite
    public void openBrowser(@Optional("chrome") String browser) throws FrameworkException {
        String curDir = System.getProperty("user.dir");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(DriversPath.chromeKey, curDir + DriversPath.chromeValue );
            driver = new ChromeDriver();
            init();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty(DriversPath.ieKey, curDir +DriversPath.ieValue);
            driver = new InternetExplorerDriver();
            init();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty(DriversPath.edgeKey, curDir + DriversPath.edgeValue);
            driver = new EdgeDriver();
            init();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(DriversPath.firefoxKey, curDir +DriversPath.firefoxValue );
            driver = new FirefoxDriver();
            init();
        } else {
            FrameworkException exception = new FrameworkException("Parameters are not matching");
            System.out.println("Parameters are not matching");
            throw exception;
        }

    }

    @AfterSuite
    public void closeBrowser() throws FrameworkException {
        if (driver != null) {
            driver.close();
        } else {
            FrameworkException exception = new FrameworkException("Driver is pointing to null");
            System.out.println("Driver is pointing to null");
            throw exception;
        }
    }

    @BeforeMethod
    public void beforeTCExecution(Method method) {
        tcName = method.getName();
        System.out.println("Current Testcase Execution is: " + tcName);
        extentTest = extentReports.startTest(tcName);
        extentTest.log(LogStatus.PASS,"Current Testcase Execution is: " + tcName);
    }

    @AfterMethod
    public void afterTCExecution(ITestResult result) throws IOException, IOException {
        tcName = result.getName();
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("TC is Passed: " + tcName);
            extentTest.log(LogStatus.PASS,"TC is Passed: " + tcName);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("TC is Failed: " + tcName);
            extentTest.log(LogStatus.FAIL,"TC is Failed: " + tcName);
            imagePath =
            extentTest.addScreenCapture(imagePath);
            extentTest.log(LogStatus.FAIL, "Exception info is: "+ result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("TC is Skipped: " + tcName);
            extentTest.log(LogStatus.SKIP,"TC is Skipped: " + tcName);
          // imagePath = ScreenshotUtility.takesScreenShot();
            extentTest.addScreenCapture(imagePath);
            extentTest.log(LogStatus.SKIP, "Exception info is: "+ result.getThrowable());
        }
        extentReports.endTest(extentTest);
        extentReports.flush();
    }


    public void init() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(59, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void initReports() {

        extentReports = new ExtentReports("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\Reports\\reports.html");


        //extentReports = new ExtentReports(System.getProperty("user.dir")+"\\src\test\\java\\Reports\\reports.html");
    }

        //"C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\Reports\\reports.html");
        //String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        //String reportFileName = "report_" + timestamp + ".html";
        //ExtentReports extent = new ExtentReports("reports/" + reportFileName);
        //extentReports = new ExtentReports("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\Reports\\report_" + reportFileName);

    @AfterTest
    public void generateReports() throws FrameworkException {
        if (extentReports!=null){
            extentReports.close();
        }
        else {
            //throw exception
            FrameworkException exception = new FrameworkException("ExtentReports pointing to null");
            System.out.println("ExtentReports pointing to null");
            throw exception;
        }
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getTcName() {
        return tcName;
    }
}

