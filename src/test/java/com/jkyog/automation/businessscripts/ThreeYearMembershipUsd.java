package com.jkyog.automation.businessscripts;

import Payment.pageobjects.PaymentPage;
import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import threeyrmembership.pageobjects.MembershipPlanPage;
import threeyrmembership.pageobjects.RegisterOneYrINRPaymentPage;
import threeyrmembership.pageobjects.RegisterThreeYrUSDPaymentPage;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ThreeYearMembershipUsd extends ActionEngine {
    public ThreeYearMembershipUsd() throws FrameworkException, IOException {
    }

    @Test
    public void ThreeYearMembershipUS() throws IOException, FrameworkException {
        boolean status = true;

        String url = PojoReader.getConfPr().getValue("prod_url");

        navigateUrl(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: " + url);
        MembershipPlanPage.clickMembershipLink();
        MembershipPlanPage.clickOnPay_inUSD_ThreeYrMbr();

        Sheet sheetObj = PojoReader.getExcelReader().getSheetObj("sheetName", "ThreeYrMembershipUS");
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


                    RegisterThreeYrUSDPaymentPage.enterFirstName(firstName);
                    RegisterThreeYrUSDPaymentPage.enterLastName(lastName);
                    RegisterThreeYrUSDPaymentPage.enterUserName(userName);
                    RegisterThreeYrUSDPaymentPage.enterEmail(email);
                    RegisterThreeYrUSDPaymentPage.enterPassword(password);
                    RegisterThreeYrUSDPaymentPage.enterReenterPwd(reenterPwd);
                    RegisterThreeYrUSDPaymentPage.clickOnFlagDropdown();
                    RegisterThreeYrUSDPaymentPage.clickOnFlag();
                    RegisterThreeYrUSDPaymentPage.enterPhoneUS(phone);
                    RegisterThreeYrUSDPaymentPage.enterCity(city);
                    RegisterThreeYrUSDPaymentPage.enterState(state);

                    RegisterThreeYrUSDPaymentPage.validateCountryUS();
                    RegisterThreeYrUSDPaymentPage.clickOnTermsAndConditions();
                    RegisterThreeYrUSDPaymentPage.clickOnRegisterButton();

                }
            }

            getDriver().switchTo().frame(0);

            Sheet sheetObj1 = PojoReader.getExcelReader().getSheetObj("sheetName", "ThreeYrMembership_Carddetails");
            if (sheetObj1 != null) {
                //for (int j = 1; j <= sheetObj.getLastRowNum(); j++) {
                row1 = sheetObj1.getRow(1);
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
                        String cardNumber = String.valueOf(row1.getCell(i));

                        String cardExpiry = String.valueOf(row1.getCell(i + 1));

                        String cardCVC = String.valueOf(row1.getCell(i + 2));

                        String cardHolderName = String.valueOf(row1.getCell(i + 3));

                        String zipcode = String.valueOf(row1.getCell(i + 4));

                        if (i > 0 && i < row1.getLastCellNum()) {
                            break;
                        }


                        RegisterThreeYrUSDPaymentPage.enterCardNumber(cardNumber);
                        RegisterThreeYrUSDPaymentPage.enterCardExpiry(cardExpiry);
                        RegisterThreeYrUSDPaymentPage.enterCardCVC(cardCVC);

                        Sheet sheetObj2 = PojoReader.getExcelReader().getSheetObj("sheetName", "ThreeYrMembership_Carddetails");

                        if (sheetObj2 != null) {
                            for (int j = 1; j <= sheetObj.getLastRowNum(); j++) {
                                row1 = sheetObj.getRow(j);
                                if (row1 != null) {
                                    for (i = 0; i < row1.getLastCellNum(); i++) {
                                        cell = row1.getCell(i);
                                        if (cell != null) {
                                            if (cell.getCellType() == CellType.STRING) {
                                                String cellValue = cell.getStringCellValue();
                                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                                String cellValue = cell.getNumericCellValue() + "";
                                            } else if (cell.getCellType() == CellType.BOOLEAN) {
                                                String cellValue = cell.getBooleanCellValue() + "";
                                            }

                                            String userName = String.valueOf(row1.getCell(i + 2));

                                            RegisterOneYrINRPaymentPage.enterCardHolderName(userName);
                                            break;
                                        }
                                    }
                                }
                            }

                            RegisterThreeYrUSDPaymentPage.dropDownCountryUS();
                            RegisterThreeYrUSDPaymentPage.enterzipcode(zipcode);
                            RegisterThreeYrUSDPaymentPage.clickOnPayButton();




                            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
                           // WebDriverWait wait = new WebDriverWait(getDriver(),  Duration.ofSeconds(10));


// Switch to the new window
                            String parentWindowHandle = getDriver().getWindowHandle();
                            Set<String> windowHandles = getDriver().getWindowHandles();
                            for (String windowHandle : windowHandles) {
                                if (!windowHandle.equals(parentWindowHandle)) {
                                    getDriver().switchTo().window(windowHandle);
                                    break;
                                }
                            }


// Optionally, you can switch back to the original window if needed
                            getDriver().switchTo().window(parentWindowHandle);
                            //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                            WebElement thankyouNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(), 'Thank you for choosing 3 year membership with JKYog Courses')]")));


                            // Validate the presence of the text in the element
                            if (thankyouNote != null) {
                                System.out.println("Text validation passed!");
                            } else {
                                System.out.println("Text validation failed!");
                            }


                   RegisterThreeYrUSDPaymentPage.clickOnGoToHomePage();
                   PaymentPage.processCellValue(row1.getCell(2));
                   PaymentPage.clickOnLogoutlink();
                       }
                    }

                }
            }
        }

    }
}