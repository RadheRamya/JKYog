package com.jkyog.automation.freeregister.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LogoutPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), FreeRegisterPage.class);
    }


    @FindBy(xpath = "//span[@class='elementor-headline-plain-text elementor-headline-text-wrapper']")
    private static WebElement imageLink;

    @FindBy(xpath = "//a[@onclick='return true' and starts-with(text(), 'Welcome')])[1]")
    private static WebElement welcomelink;

    @FindBy(xpath = "//a[@class='elementor-sub-item menu-link' and text()='Logout'][1]")
    private static WebElement logout;

    @FindBy(xpath = "(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]")
    private static WebElement openArrow;

    public static void clickOnImagelink() {
        boolean status = true;
        try {
            Assert.assertTrue(imageLink.isDisplayed() && imageLink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Image link element is displayed and enabled ");
            imageLink.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Image link element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Image link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Image link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Image link element");
        }
    }


    public static void clickOnWelcomeOpenlink() {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            //Find the WebElement you want to hover over using its XPath
            WebElement elementToHoverOver  = welcomelink;

           //Create an ActionChains object

            Actions actions = new Actions(getDriver());


            // Perform the hover action
            actions.moveToElement(elementToHoverOver).build().perform();
           // wait.until(ExpectedConditions.elementToBeClickable(welcomelink));

            Assert.assertTrue(welcomelink.isDisplayed() && welcomelink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Open link element is displayed and enabled ");
            welcomelink.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Open link element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Open link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Open link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Open link element");
        }
    }

    public static void clickOnLogoutlink() {
        boolean status = true;
        try {
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
        public static void clickOnOpenArrow() {
            boolean status = true;
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), 20);
               // wait.until(ExpectedConditions.elementToBeClickable(openArrow));
                Assert.assertTrue(openArrow.isDisplayed() && openArrow.isEnabled());
                getExtentTest().log(LogStatus.PASS, "Open arrow element is displayed and enabled ");
                openArrow.click();
                getExtentTest().log(LogStatus.PASS, "Clicking action is done on Open arrow element ");
            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Open arrow element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Open arrow element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Open arrow element");
            }
        }
    }


