package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.BaseTest;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() throws IOException, FrameworkException {

        String sheetName = "Userlist";
        String url = PojoReader.getConfPr().getValue("prod_url");
        getDriver().get(url);
        //navigateUrl(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: "+url);


        String loginlink = PojoReader.getOrPr().getValue("login_xpath");
        getExtentTest().log(LogStatus.PASS,  "Login link entered is ");
        WebElement login = getDriver().findElement(By.xpath(loginlink));
        login.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on login or register link ");

        String unIdValue = PojoReader.getOrPr().getValue("un_xpath");
        WebElement userName = getDriver().findElement(By.xpath(unIdValue));
        userName.clear();
        getExtentTest().log(LogStatus.PASS, "Username is cleared ");

        String unData = PojoReader.getExcelReader().getCellData("sheetName", "Userlist",1,0);
        userName.sendKeys(unData);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Username with testdata as: "+unData);

        String pwdIdValue = PojoReader.getOrPr().getValue("pwd_xpath");
        WebElement password = getDriver().findElement(By.xpath(pwdIdValue));
        password.clear();
        getExtentTest().log(LogStatus.PASS, "Password is cleared ");

        String pwdData = PojoReader.getExcelReader().getCellData("sheetName", "Userlist",1,1);
        password.sendKeys(pwdData);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Password with testdata as: "+pwdData);

        String loginIdValue = PojoReader.getOrPr().getValue("login_id");
        WebElement loginButton = getDriver().findElement(By.xpath(loginIdValue));
        getExtentTest().log(LogStatus.PASS, "Login button is displayed ");
        loginButton.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on login button ");

        /*
         FileInputStream fipConf = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\config.properties");
        Properties prConf = new Properties();
        prConf.load(fipConf);
        String url = prConf.getProperty("prod_url");

           FileInputStream fipOr = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\login\\objectrepository\\or_jkyog.properties");
        Properties prOr = new Properties();
        prOr.load(fipOr);
        prOr.getProperty("login_xpath");

            String unIdValue = prOr.getProperty("un_id");
        String pwdIdValue = prOr.getProperty("pwd_id");
        String loginIdValue = prOr.getProperty("login_id");*/


      /*  String loginlink = PojoReader.getOrPr().getValue("login_xpath");
        getExtentTest().log(LogStatus.PASS,  "Login link entered is: "+loginlink);
        WebElement login = getDriver().findElement(By.xpath(loginlink));
        login.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on login link: "+login);

        String unIdValue = PojoReader.getOrPr().getValue("un_id");
        getExtentTest().log(LogStatus.PASS, "Username value entered is:  "+unIdValue);

        String pwdIdValue =  PojoReader.getOrPr().getValue("pwd_id");
        getExtentTest().log(LogStatus.PASS, "password value entered is: "+pwdIdValue);

        String unData = PojoReader.getExcelReader().getCellData("sheetName", "Userlist",1,0);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Username with testdata as: "+unData);

        String pwdData = PojoReader.getExcelReader().getCellData("sheetName", "Userlist",1,1);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Username with testdata as : "+pwdData);

        // Assuming the first row contains headers, so we start from rowIndex = 1
           *//* for (int rowIndex = 1; rowIndex <= PojoReader.getExcelReader().getRowCount(sheetName); rowIndex++) {
            String unData = PojoReader.getExcelReader().getCellData(sheetName,"User List",i, j);
            String pwdData = PojoReader.getExcelReader().getCellData(sheetName, rowIndex, 1);*//*


        WebElement userName = getDriver().findElement(By.xpath(unIdValue));
        userName.clear();
        getExtentTest().log(LogStatus.PASS, "Username is cleared: "+userName);
        userName.sendKeys(unData);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Username with testdata as : "+unData);

        WebElement password = getDriver().findElement(By.xpath(pwdIdValue));
        password.sendKeys(pwdData);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Username with testdata as : "+pwdData);


        String loginIdValue = PojoReader.getOrPr().getValue("login_id");
        WebElement loginButton = getDriver().findElement(By.xpath(loginIdValue));
        getExtentTest().log(LogStatus.PASS, "Login button is displayed: "+loginIdValue);
        loginButton.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on login button: "+loginButton);*/

    }
}