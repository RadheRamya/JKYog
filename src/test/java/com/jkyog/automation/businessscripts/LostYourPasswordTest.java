package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.loginpage.pageobjects.LostYourPasswordPage;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LostYourPasswordTest extends ActionEngine {

    private LostYourPasswordPage lostYourPasswordPage;
    @Test
    public void LostYourPasswordTest() throws IOException, FrameworkException {

        String sheetName = "Userlist";
        String url = PojoReader.getConfPr().getValue("prod_url");
        getDriver().get(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: "+url);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String loginlink = PojoReader.getOrPr().getValue("login_xpath");
        getExtentTest().log(LogStatus.PASS,  "Login link entered is ");
        WebElement login = getDriver().findElement(By.xpath(loginlink));
        login.click();
        getExtentTest().log(LogStatus.PASS, "Clicking on login or register link ");

        LostYourPasswordPage.clickOnLostYourPasswordLink();

        String lostPWD = PojoReader.getExcelReader().getCellData("sheetName", "LostYourPassword",1,0);
        LostYourPasswordPage.enterUsername(lostPWD);
        getExtentTest().log(LogStatus.PASS, "Data typing action done on Username with testdata as: "+lostPWD);

        LostYourPasswordPage.clickOnGetNewPassword();

        LostYourPasswordPage.validateTextAppearing();
    }

}
