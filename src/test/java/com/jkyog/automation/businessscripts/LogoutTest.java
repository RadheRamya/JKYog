package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.freeregister.pageobjects.LogoutPage;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTest extends ActionEngine {
    @Test
    public void logoutTest() throws IOException, FrameworkException {

        String sheetName = "Userlist";
        String url = PojoReader.getConfPr().getValue("prod_url");
        // getDriver().get(url);
        navigateUrl(url);
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

        String pwdData = PojoReader.getExcelReader().getCellData("sheetName", "Userlist",1,1);
        String pwdIdValue =  PojoReader.getOrPr().getValue("pwd_xpath");
        WebElement pwd = getDriver().findElement(By.xpath(pwdIdValue));

        pwd.sendKeys(pwdData);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Password with testdata as: "+pwdData);

        String loginIdValue = PojoReader.getOrPr().getValue("login_id");
        WebElement loginButton = getDriver().findElement(By.xpath(loginIdValue));
        getExtentTest().log(LogStatus.PASS, "Login button is displayed ");
        loginButton.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on login button ");


        LogoutPage.clickOnWelcomeOpenlink();
        LogoutPage.clickOnLogoutlink();
/*
        LogoutPage.clickOnOpenArrow();
        LogoutPage.clickOnArrowlink();
        LogoutPage.clickOnLogoutlink();
        LogoutPage.clickOnWelcomeOpenlink();*/

    }

}
