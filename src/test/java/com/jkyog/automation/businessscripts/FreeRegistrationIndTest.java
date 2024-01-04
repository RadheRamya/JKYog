package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.freeregister.pageobjects.FreeRegisterPage;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.io.IOException;

public class FreeRegistrationIndTest extends ActionEngine {
    public FreeRegistrationIndTest() throws FrameworkException, IOException {
    }

    @Test
    public void verifyIndFreeRegistration() throws IOException, FrameworkException {
        boolean status = true;

        String url = PojoReader.getConfPr().getValue("prod_url");

        navigateUrl(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: " + url);
        FreeRegisterPage.clickOnRegisterlink();
        FreeRegisterPage.clickOnRegisterButtonToFillDetails();


        Sheet sheetObj = PojoReader.getExcelReader().getSheetObj("sheetName", "FreeMembership");
        if (sheetObj != null) {
            //for (int j = 1; j <= sheetObj.getLastRowNum(); j++) {
            Row row1 = sheetObj.getRow(1);
            if (row1 != null) {

                for (int i = 0; i < row1.getLastCellNum(); i++) {
                    Cell cell = row1.getCell(i);
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        String cellValue = cell.getNumericCellValue() + "";
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        String cellValue = cell.getBooleanCellValue() + "";
                    }
                    String firstName = String.valueOf(row1.getCell(i));

                    String lastName = String.valueOf(row1.getCell(i + 1));

                    String userName = String.valueOf(row1.getCell(i + 2));

                    String email = String.valueOf(row1.getCell(i + 3));

                    String password = String.valueOf(row1.getCell(i + 4));

                    String reenterPwd = String.valueOf(row1.getCell(i + 5));

                    String phone = String.valueOf(row1.getCell(i + 6));

                    String city = String.valueOf(row1.getCell(i + 7));

                    String state = String.valueOf(row1.getCell(i + 8));

                    if (i > 0 && i < row1.getLastCellNum()) {
                        break;
                    }


                    FreeRegisterPage.enterFirstName(firstName);
                    FreeRegisterPage.enterLastName(lastName);
                    FreeRegisterPage.enterUserName(userName);
                    FreeRegisterPage.enterEmail(email);
                    FreeRegisterPage.enterPassword(password);
                    FreeRegisterPage.enterReenterPwd(reenterPwd);
                    FreeRegisterPage.enterPhoneInd(phone);
                    FreeRegisterPage.enterCity(city);
                    FreeRegisterPage.enterState(state);

                    FreeRegisterPage.dropDownCountryInd();
                    FreeRegisterPage.clickOnTermsAndConditions();
                    FreeRegisterPage.clickOnRegisterButton();


                    FreeRegisterPage.processCellValue(row1.getCell(2));
                    //FreeRegisterPage.openUNLink();
                    FreeRegisterPage.clickOnLogoutlink();


                }
            }
        }
    }

}