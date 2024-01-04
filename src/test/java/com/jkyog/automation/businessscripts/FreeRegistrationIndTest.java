package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.base.BaseTest;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.freeregister.pageobjects.FreeRegisterPage;
import com.jkyog.automation.supporters.ExcelReader;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FreeRegisterTest extends ActionEngine {
    public FreeRegisterTest() throws FrameworkException, IOException {
    }
    //public static void main(String[] args) {
    //verifyFreeRegistration();

    @Test
    public void verifyFreeRegistration() throws IOException, FrameworkException {
        String sheetName = "FreeMembership";
        String url = PojoReader.getConfPr().getValue("prod_url");
        navigateUrl(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: " + url);
        FreeRegisterPage.clickOnRegisterlink();
        FreeRegisterPage.clickOnRegisterButtonToFillDetails();


        List<String> sheetData = PojoReader.getExcelReader().getSheetData("sheetName", "FreeMembership");


        if (sheetData != null && !sheetData.isEmpty()) {
            if (sheetData.size() % 9 != 0) {
                getExtentTest().log(LogStatus.ERROR, "Invalid data structure: Data should be in multiples of 8 fields.");
                return;
            }
            for (int i = 0; i < sheetData.size(); i += 9) {
                String firstName = sheetData.get(i);

                String lastName = sheetData.get(i + 1);

                String userName = sheetData.get(i + 2);

                String email = sheetData.get(i + 3);

                String password = sheetData.get(i + 4);

                String reenterPwd = sheetData.get(i + 5);

                String phone = sheetData.get(i + 6);

                String city = sheetData.get(i + 7);

                String state = sheetData.get(i + 8);


                FreeRegisterPage.enterFirstName(firstName);
                FreeRegisterPage.enterLastName(lastName);
                FreeRegisterPage.enterUserName(userName);
                FreeRegisterPage.enterEmail(email);
                FreeRegisterPage.enterPassword(password);
                FreeRegisterPage.enterReenterPwd(reenterPwd);
                FreeRegisterPage.enterPhone(phone);
                FreeRegisterPage.enterCity(city);
                FreeRegisterPage.enterState(state);

                FreeRegisterPage.dropDownCountry();
                FreeRegisterPage.clickOnTermsAndConditions();
                FreeRegisterPage.clickOnRegisterButton();

            }

        }

        List<String> sheetData1 = PojoReader.getExcelReader().getSheetData("sheetName", "FreeMembership");
        String welcomeUNData = sheetData1.get(3);
        FreeRegisterPage.verifyWelcomeUN(welcomeUNData);

    }

}























