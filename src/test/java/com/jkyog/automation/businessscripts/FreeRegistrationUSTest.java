package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.freeregister.pageobjects.FreeRegisterPage;
import com.jkyog.automation.utilities.PojoReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;
import java.lang.String;

import java.io.IOException;

public class FreeRegistrationUSTest extends ActionEngine {

    public FreeRegistrationUSTest() throws FrameworkException, IOException {
    }

    @Test
    public void verifyUSFreeRegistration() throws IOException, FrameworkException {
        String sheetName = "FreeMembership";

        FreeRegisterPage.clickOnRegisterlink();
        FreeRegisterPage.clickOnRegisterButtonToFillDetails();

        Sheet sheetObj = PojoReader.getExcelReader().getSheetObj("sheetName", "FreeMembership");
        if (sheetObj != null) {
            Row row2 = sheetObj.getRow(2);
            if (row2 != null) {
                for (int j = 0; j < row2.getLastCellNum(); j++) {
                    Cell cell = row2.getCell(j);
                    if (cell.getCellType() == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        String cellValue = cell.getNumericCellValue() + "";
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        String cellValue = cell.getBooleanCellValue() + "";
                    }
                    String firstName1 = String.valueOf(row2.getCell(j));

                    String lastName1 = String.valueOf(row2.getCell(j + 1));

                    String userName1 = String.valueOf(row2.getCell(j + 2));

                    String email1 = String.valueOf(row2.getCell(j + 3));

                    String password1 = String.valueOf(row2.getCell(j + 4));

                    String reenterPwd1 = String.valueOf(row2.getCell(j + 5));

                    String phone1 = String.valueOf(row2.getCell(j + 6));

                    String city1 = String.valueOf(row2.getCell(j + 7));

                    String state1 = String.valueOf(row2.getCell(j + 8));

                    if (j > 0 && j < row2.getLastCellNum()) {
                        break;
                    }


                    FreeRegisterPage.enterFirstName(firstName1);
                    FreeRegisterPage.enterLastName(lastName1);
                    FreeRegisterPage.enterUserName(userName1);
                    FreeRegisterPage.enterEmail(email1);
                    FreeRegisterPage.enterPassword(password1);
                    FreeRegisterPage.enterReenterPwd(reenterPwd1);
                    FreeRegisterPage.enterPhoneUS(phone1);
                    FreeRegisterPage.enterCity(city1);
                    FreeRegisterPage.enterState(state1);

                    FreeRegisterPage.dropDownCountryUS();
                    FreeRegisterPage.clickOnTermsAndConditions();
                    FreeRegisterPage.clickOnRegisterButton();

                    FreeRegisterPage.processCellValue(row2.getCell(2));
                    //FreeRegisterPage.openUNLink();
                    FreeRegisterPage.clickOnLogoutlink();
                }

            }

        }
    }
}








































