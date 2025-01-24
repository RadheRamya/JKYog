package com.jkyog.automation.loginpage.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LostYourPasswordPage extends BaseTest {
    static {
        PageFactory.initElements(getDriver(), LostYourPasswordPage.class);
    }

    @FindBy(xpath = "//a[@class='elementor-lost-password']")
    private static WebElement lostYourPassword;

    @FindBy(id = "user_login")
    private static WebElement userName;

    @FindBy(id = "wp-submit")
    private static WebElement getNewPassword;

    @FindBy(xpath = "//p[contains(text(),'Please enter your username')]")
    private static WebElement textAppear;

    public static void clickOnLostYourPasswordLink() {
        boolean status = true;
        try {
            Assert.assertTrue(lostYourPassword.isDisplayed() && lostYourPassword.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Lost Your Password link element is displayed and enabled ");
            lostYourPassword.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Lost Your Password link element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Lost Your Password link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Lost Your Password link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Lost Your Password link element");
        }
    }

    public static void enterUsername(String unData) {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
           // WebElement userName = getDriver().findElement(By.id("user"));
            Assert.assertTrue(userName.isDisplayed() && userName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Username element is displayed and enabled ");

            userName.clear();
            getExtentTest().log(LogStatus.PASS, "Username element is cleared ");

            userName.sendKeys(unData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on UserName element");

            getExtentTest().log(LogStatus.PASS, "Clicking action is done on UserName element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Username element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Username element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Username element");
        }
    }


    public static void clickOnGetNewPassword() {
        boolean status = true;
        try {
           // WebElement loginButton = getDriver().findElement(By.xpath("//span[text() = 'Log In']"));
            Assert.assertTrue(getNewPassword.isDisplayed() && getNewPassword.isEnabled());
            getExtentTest().log(LogStatus.PASS, "GetNewPassword element is displayed and enabled ");
            getNewPassword.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on GetNewPassword element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "GetNewPassword button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on GetNewPassword button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on GetNewPassword button element");
        }
    }

    public static void validateTextAppearing() {
        boolean status = true;
        try {
            Assert.assertTrue(textAppear.isDisplayed() && textAppear.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Text for Lost Password is displayed in the page ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Text is NOT displayed in the page");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Lost Your Password text is displayed");
            } else
                getExtentTest().log(LogStatus.FAIL, "Lost Your Password text is NOT displayed");
        }
    }

}
