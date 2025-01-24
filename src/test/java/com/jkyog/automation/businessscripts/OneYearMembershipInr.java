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

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OneYearMembershipInr extends ActionEngine {
    public OneYearMembershipInr() throws FrameworkException, IOException {
    }

    @Test
    public void OneYearMembershipInd() throws IOException, FrameworkException {
        boolean status = true;

        String url = PojoReader.getConfPr().getValue("prod_url");

        navigateUrl(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: " + url);
        MembershipPlanPage.clickMembershipLink();
        MembershipPlanPage.clickOnPay_inINR_OneYrMbr();

        Sheet sheetObj = PojoReader.getExcelReader().getSheetObj("sheetName", "OneYrMembershipIND");
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

                    RegisterOneYrINRPaymentPage.enterFirstName(firstName);
                    RegisterOneYrINRPaymentPage.enterLastName(lastName);
                    RegisterOneYrINRPaymentPage.enterUserName(userName);
                    RegisterOneYrINRPaymentPage.enterEmail(email);
                    RegisterOneYrINRPaymentPage.enterPassword(password);
                    RegisterOneYrINRPaymentPage.enterReenterPwd(reenterPwd);
                    RegisterOneYrINRPaymentPage.enterPhoneInd(phone);
                    RegisterOneYrINRPaymentPage.enterCity(city);
                    RegisterOneYrINRPaymentPage.enterState(state);
                    RegisterOneYrINRPaymentPage.validateCountryInd_OneYrINR();
                    RegisterOneYrINRPaymentPage.clickOnTermsAndConditions();
                    RegisterOneYrINRPaymentPage.clickOnRegisterButton();

                }
            }

            getDriver().switchTo().frame(0);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            WebElement bank = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='radio-display'][1]")));
            bank.click();


            WebElement payNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='redesign-v15-cta']")));
            payNow.click();
            getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);


// Switch to the new window
                String parentWindowHandle = getDriver().getWindowHandle();
                Set<String> windowHandles = getDriver().getWindowHandles();
                for (String windowHandle : windowHandles) {
                    if (!windowHandle.equals(parentWindowHandle)) {
                        getDriver().switchTo().window(windowHandle);
                        break;
                    }
                }

// Wait for the presence of the element in the new window
                WebElement success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='success']")));
                success.click();

// Optionally, you can switch back to the original window if needed
                getDriver().switchTo().window(parentWindowHandle);
                WebElement thankyouNote = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(), 'Thank you for choosing 1 year membership with JKYog Courses')]")));

                // Validate the presence of the text in the element
                if (thankyouNote != null) {
                    System.out.println("Text validation passed!");
                } else {
                    System.out.println("Text validation failed!");
                }

               getDriver().findElement(By.xpath("//span[@class='elementor-button-text']")).click();

            PaymentPage.processCellValue(row1.getCell(2));
            PaymentPage.clickOnLogoutlink();

            }
            }
        }