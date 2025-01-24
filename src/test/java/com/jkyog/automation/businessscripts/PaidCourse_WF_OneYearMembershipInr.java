package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.courses.pageobjects.CoursesPage;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.loginpage.pageobjects.LoginPage;
import com.jkyog.automation.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaidCourse_WF_OneYearMembershipInr extends ActionEngine {
    public PaidCourse_WF_OneYearMembershipInr() throws FrameworkException, IOException {
    }

    @Test
    public void PaidCourse_WF_OneYearMembershipInr() throws IOException, FrameworkException {
        boolean status = true;

        String url = PojoReader.getConfPr().getValue("prod_url");

        navigateUrl(url);
        getExtentTest().log(LogStatus.PASS, "URL is entered as: " + url);

        LoginPage.clickOnLoginRegisterLink();

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

                    String userName = String.valueOf(row1.getCell(i + 2));

                    String password = String.valueOf(row1.getCell(i + 4));

                    if (i > 0 && i < row1.getLastCellNum()) {
                        break;
                    }


                    LoginPage.enterUsername(userName);
                    LoginPage.enterPassword(password);
                    LoginPage.clickOnLogIn();

                }

                CoursesPage.clickOnCoursesLink();
                CoursesPage.clickOnPaidCheckbox();
                CoursesPage.validate_StartorContinue_Learningbutton();
                CoursesPage.clickOnPageNumber(1);
                CoursesPage.clickOnStartOrContinueLearningButton();
                CoursesPage.clickOnLessons_Session1();
                CoursesPage.clickOnPlayButton();
                CoursesPage.moveCursorToEndOfVideo();










            }

         /*   getDriver().switchTo().frame(0);
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
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
            PaymentPage.clickOnLogoutlink();*/

            }
            }
        }