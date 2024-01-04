package com.jkyog.automation.freeregister.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FreeRegister extends BaseTest {

    @FindBy(xpath = "//span[@class='elementor-button-text' and text()='Register']")
    private static WebElement register;

    @FindBy(id = "//input[@id='ff_11_names_first_name_']")
    private static WebElement firstName;

    @FindBy(id = "//input[@id='ff_11_names_last_name_']")
    private static WebElement lastName;

    @FindBy(id = "//input[@id='ff_11_input_text']")
    private static WebElement userName;

    @FindBy(id = "//input[@id='ff_11_email']")
    private static WebElement email;

    @FindBy(id = "//input[@id='ff_11_password']")
    private static WebElement password;

    @FindBy(id = "//input[@id='ff_11_password_2']")
    private static WebElement reenter_pwd;

    @FindBy(id = "//input[@id='ff_11_phone']")
    private static WebElement phone;

    @FindBy(id = "//input[@id='ff_11_country-list']")
    private static WebElement country;

    @FindBy(xpath = "//p[text()='I have read and agree to the ']")
    private static WebElement termsNCond;

    @FindBy(xpath = "//button[text()='Register']")
    private static WebElement registerbtn;

    @FindBy(id = "//input[@id='ff_11_city']")
    private static WebElement city;

    @FindBy(id = "//input[@id='ff_11_state']")
    private static WebElement state;

    public static void clickOnRegisterlink() {
        boolean status = true;
        try {
            Assert.assertTrue(register.isDisplayed() && register.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register element is displayed and enabled ");
            register.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Register element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Register element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Register element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Register element");
        }
    }

        public static void enterUserName(String unData) {
        boolean status = true;
        try {
            Assert.assertTrue(userName.isDisplayed() && userName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Username element is displayed and enabled ");
            userName.clear();
            getExtentTest().log(LogStatus.PASS, "Username element is cleared ");
            userName.sendKeys(unData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on UserName elememt");
        } catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "UserName elememt is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on UserName elememt");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on UserName elememt");
        }
    }


    public static void enterFirstName(String firstNameData) {
        boolean status = true;
        try {
            Assert.assertTrue(firstName.isDisplayed() && firstName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Firstname element is displayed and enabled ");
            firstName.clear();
            getExtentTest().log(LogStatus.PASS, "Firstname element is cleared ");
            firstName.sendKeys(firstNameData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element");
        }
        catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Firstname element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Firstname element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Firstname element");
        }
        }


    public static void enterLastName(String lastNameData) {
        boolean status = true;
        try {
            Assert.assertTrue(lastName.isDisplayed() && lastName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Lastname element is displayed and enabled ");
            lastName.clear();
            getExtentTest().log(LogStatus.PASS, "Lastname element is cleared ");
            lastName.sendKeys(lastNameData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Lastname element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Lastname element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Lastname element");
        }
    }

    public static void enterEmail(String emailData) {
        boolean status = true;
        try {
            Assert.assertTrue(email.isDisplayed() && email.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Email element is displayed and enabled ");
            email.clear();
            getExtentTest().log(LogStatus.PASS, "Email element is cleared ");
            email.sendKeys(emailData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Email element");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Email element is NOT displayed and enabled");
            status= false;
        }
            finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Email element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Email element");
        }
    }



    public static void enterPassword(String passwordData) {
        boolean status = true;
        try {
            Assert.assertTrue(password.isDisplayed() && password.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Password element is displayed and enabled ");
            password.clear();
            getExtentTest().log(LogStatus.PASS, "Password element is cleared ");
            password.sendKeys(passwordData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Password element");
        }catch (Exception exception){
        getExtentTest().log(LogStatus.FAIL, "Password element is NOT displayed and enabled");
        status= false;
    }
            finally {
        if(status) {
            getExtentTest().log(LogStatus.PASS, "Action is done on Password element");
        }
        else
            getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Password element");
    }
}


    public static void enterReenterPwd(String reenterPwdData) {
        boolean status = true;
        try {
            Assert.assertTrue(reenter_pwd.isDisplayed() && reenter_pwd.isEnabled());
            getExtentTest().log(LogStatus.PASS, "ReEnter-Password element is displayed and enabled ");
            reenter_pwd.clear();
            getExtentTest().log(LogStatus.PASS, "ReEnter-Password element is cleared ");
            reenter_pwd.sendKeys(reenterPwdData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on ReEnter-Password element");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "ReEnter-Password element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on ReEnter-Password element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on ReEnter-Password element");
        }
    }

    public static void enterPhone(String phoneData) {
        boolean status = true;
        try {
            Assert.assertTrue(phone.isDisplayed() && phone.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Phone element is displayed and enabled ");
            phone.clear();
            getExtentTest().log(LogStatus.PASS, "Phone element is cleared ");
            phone.sendKeys(phoneData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Phone element");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Phone element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Phone element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Phone element");
        }

    }

    public static void enterCity(String cityData) {
        boolean status = true;
        try {
            Assert.assertTrue(city.isDisplayed() && city.isEnabled());
            getExtentTest().log(LogStatus.PASS, "City element is displayed and enabled ");
            city.clear();
            getExtentTest().log(LogStatus.PASS, "City element is cleared ");
            city.sendKeys(cityData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on City element");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "City element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on City element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on City element");
        }

    }

    public static void enterState(String stateData) {
        boolean status = true;
        try {
            Assert.assertTrue(state.isDisplayed() && state.isEnabled());
            getExtentTest().log(LogStatus.PASS, "State element is displayed and enabled ");
            state.clear();
            getExtentTest().log(LogStatus.PASS, "State element is cleared ");
            phone.sendKeys(stateData);
            getExtentTest().log(LogStatus.PASS, "State typing action is done on City element");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "State element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on State element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on State element");
        }

    }

    public static void clickOnRegisterButton() {
        boolean status = true;
        try {
            Assert.assertTrue(registerbtn.isDisplayed() && registerbtn.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register element is displayed and enabled ");
            registerbtn.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Register element ");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Register element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Register element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Register element");
        }

       }

    public static void ClickOnTermsAndConditions() {
        boolean status= true;
        try {
            Assert.assertTrue(termsNCond.isDisplayed() && termsNCond.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Terms and Conditions element is displayed and enabled ");
            termsNCond.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Terms and Conditions element ");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Terms and Conditions element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Terms and Conditions element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Terms and Conditions element");
        }
    }

    public static void DropDownCountry() {
        boolean status= true;
        try {
            Assert.assertTrue(country.isDisplayed() && country.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Country element is displayed and enabled ");
            Select select = new Select(country);
            select.selectByVisibleText("India");
            getExtentTest().log(LogStatus.PASS, "Selecting action is done on Country dropdown element with data India ");
        }catch (Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Country element is NOT displayed and enabled");
            status= false;
        }
        finally {
            if(status) {
                getExtentTest().log(LogStatus.PASS, "Country is done on Lastname element");
            }
            else
                getExtentTest().log(LogStatus.FAIL, "Country is NOT done on Lastname element");
        }

    }

}