package com.jkyog.automation.freeregister.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class LogoutPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), FreeRegisterPage.class);
    }

    @FindBy(xpath = "//a[@onclick='return true' and starts-with(text(), 'Welcome')][1]")
    private static WebElement welcomelink;

    @FindBy(xpath = "//a[@class='elementor-sub-item menu-link' and text()='Logout'][1]")
    private static WebElement logout;



    public static void clickOnWelcomeOpenlink() {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            WebElement welcomelink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@onclick='return true' and starts-with(text(), 'Welcome')][1]")));
            //wait.until(ExpectedConditions.elementToBeClickable(welcomelink)).click();

            Assert.assertTrue(welcomelink.isDisplayed() && welcomelink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Welcome link element is displayed and enabled ");
            welcomelink.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Welcome link element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Welcome link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Welcome link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Welcome link element");
        }
    }

    public static void clickOnLogoutlink() {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='elementor-sub-item menu-link' and text()='Logout'][1]")));
            Assert.assertTrue(logout.isDisplayed() && logout.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Logout element is displayed and enabled ");
            logout.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Logout element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Logout element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Logout element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Logout element");
        }
    }
}


