package com.jkyog.automation.loginpage.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.jkyog.automation.freeregister.pageobjects.FreeRegisterPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseTest {
    static {
        PageFactory.initElements(getDriver(), FreeRegisterPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//span[text() = 'Log In | Register']")
    private static WebElement loginOrRegister;

    @FindBy(id = "user")
    private static WebElement userName;

    @FindBy(id = "password")
    private static WebElement password_login;

    @FindBy(xpath = "//span[text() = 'Log In']")
    private static WebElement loginButton;

    public static void clickOnLoginRegisterLink() {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement loginOrRegister = getDriver().findElement(By.xpath("//span[text() = 'Log In | Register']"));
            Assert.assertTrue(loginOrRegister.isDisplayed() && loginOrRegister.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Login or Register element is displayed and enabled ");
            loginOrRegister.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Login or Register element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Login or Register link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Login or Register link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Login or Register link element");
        }
    }

    public static void enterUsername(String unData) {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            WebElement userName = getDriver().findElement(By.id("user"));
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

    public static void enterPassword(String pwdData) {
        boolean status = true;
        try {
            //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            WebElement password_login = getDriver().findElement(By.id("password"));
            Assert.assertTrue(password_login.isDisplayed() && password_login.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Password element is displayed and enabled ");
            password_login.sendKeys(pwdData);
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Password element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Password element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Password element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Password element");
        }
    }


    public static void clickOnLogIn() {
        boolean status = true;
        try {
            WebElement loginButton = getDriver().findElement(By.xpath("//span[text() = 'Log In']"));
            Assert.assertTrue(loginButton.isDisplayed() && loginButton.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Login element is displayed and enabled ");
            loginButton.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Login element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Login button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Login button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Login button element");
        }
    }

}
