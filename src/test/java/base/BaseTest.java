package base;

import Utilities.DriversPath;
import Utilities.ScreenshotUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    private static String tcName;

    @Parameters({"browser"})
    @BeforeSuite
    public void openBrowser(@Optional("chrome") String browser) {
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
            System.out.println("Parameters are mot matching");
        }

    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        } else {
            System.out.println("Driver is pointing to null");
        }
    }

    @BeforeMethod
    public void beforeTCExecution(Method method) {
        tcName = method.getName();
        System.out.println("Current Testcase Execution is: " + tcName);
    }

    @AfterMethod
    public void afterTCExecution(ITestResult result) throws IOException {
        tcName = result.getName();
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("TC is Passed: " + tcName);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("TC is Failed: " + tcName);
            ScreenshotUtility.takesScreenShot();
        } else if (result.getStatus() == ITestResult.SKIP) {
            System.out.println("TC is Skipped: " + tcName);
            ScreenshotUtility.takesScreenShot();
        }
    }

    public void init() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(59, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getTcName() {
        return tcName;
    }
}

