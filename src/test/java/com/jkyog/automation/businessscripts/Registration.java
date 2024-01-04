package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.BaseTest;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Registration extends BaseTest {

    @Test
    public void RegistrationTest() throws IOException, FrameworkException {

        /*FileInputStream fipConf = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\config.properties");
        Properties prConf = new Properties();
        prConf.load(fipConf);
        String url = prConf.getProperty("prod_url");*/

        String sheetName = "Userlist";
        String url = PojoReader.getConfPr().getValue("prod_url");
        getDriver().get(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: "+url);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       /* FileInputStream fipOr = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\login\\objectrepository\\or_jkyog.properties");
        Properties prOr = new Properties();
        prOr.load(fipOr);
        String registerIdValue = prOr.getProperty("register_xpath");*/

        String registerIdValue =  PojoReader.getOrPr().getValue("register_xpath");
        getExtentTest().log(LogStatus.PASS,  "register value entered is: "+registerIdValue);
        WebElement register = getDriver().findElement(By.xpath(registerIdValue));
        register.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on register link: "+register);
        // Create a JavascriptExecutor instance
        //JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by a specified number of pixels
        //int scrollPixels = 500; // Adjust the value as needed
        //js.executeScript("window.scrollBy(0, " + scrollPixels + ");");
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.elementToBeClickable(tnc));
        //if (!tnc.isSelected()) {

               /* JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", tnc);*/



        //getDriver().findElement(By.xpath("//span[text() = 'Log In']")).click();
        //getDriver().findElement(By.xpath("//span[text() ='Register']")).click();
    }

}
