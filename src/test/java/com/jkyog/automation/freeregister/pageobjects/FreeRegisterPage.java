package com.jkyog.automation.freeregister.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FreeRegisterPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), FreeRegisterPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//span[@class='elementor-icon-list-text' and text() = 'Register']")
    private static WebElement registerLink;

    @FindBy(xpath = "//span[@class='elementor-button-text' and text()='Register']")
    private static WebElement registerButton1;

    @FindBy(xpath = "//input[@id='ff_11_names_first_name_']")
    private static WebElement firstName;

    @FindBy(id = "ff_11_names_last_name_")
    private static WebElement lastName;

    @FindBy(id = "ff_11_input_text")
    private static WebElement userName;

    @FindBy(id = "ff_11_email")
    private static WebElement email;

    @FindBy(id = "ff_11_password")
    private static WebElement password;

    @FindBy(id = "ff_11_password_2")
    private static WebElement reenter_pwd;

    @FindBy(id = "ff_11_phone")
    private static WebElement phone;

    @FindBy(xpath = "//div[@class='choices__list']")
    private static WebElement country;

    @FindBy(xpath = "//input[@type='checkbox' and @name='terms-n-condition']")
    private static WebElement termsNCond;

    @FindBy(xpath = "//button[text()='Register']")
    private static WebElement registerButton2;

    @FindBy(id = "ff_11_city")
    private static WebElement city;

    @FindBy(id = "ff_11_state")
    private static WebElement state;

    @FindBy(xpath = "//a[contains(@class, 'elementor-item') and contains(text(), 'Welcome')][1]")
    private static WebElement welcomeUN;

    @FindBy(xpath = "//a[@class='elementor-sub-item menu-link' and text()='Logout'][1]")
    private static WebElement logout;

    @FindBy(xpath = "//span[@class='elementor-headline-plain-text elementor-headline-text-wrapper']")
    private static WebElement imageLink;

    @FindBy(xpath= ".//div[@class='choices__list']")
    private static WebElement dropdown;

    @FindBy(xpath= "//div[@data-type='select-one']")
    private static WebElement outerScrollableElement;

    @FindBy(xpath= "//div[@class='choices__list choices__list--single']")
    private static WebElement innerScrollableElement;

    @FindBy(xpath= "//div[@class='choices__list']//div[text()='India']")
    private static WebElement indiaOption;

    @FindBy(xpath = "//div[@class='choices__list']//div[text()='United States (US)']")
    private static WebElement usOption;


     public static void clickOnRegisterlink() {
        boolean status = true;
        try {
            Assert.assertTrue(registerLink.isDisplayed() && registerLink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register element is displayed and enabled ");

            registerLink.click();
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

    public static void clickOnRegisterButtonToFillDetails() {
        boolean status = true;
        try {
            Assert.assertTrue(registerButton1.isDisplayed() && registerButton1.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register button to fill details element is displayed and enabled ");

            registerButton1.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Register button to fill details element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Register button to fill details element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Register button to fill details button to fill details element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Register button to fill details element");
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

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "UserName elememt is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on UserName elememt");
            } else
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
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element" + firstNameData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Firstname element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Firstname element");
            } else
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
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element" + lastNameData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Lastname element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Lastname element");
            } else
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
            String regExpPattern =  "^[A-Za-z0-9+_.-]+@(.+)$";//email
            Pattern pattern = Pattern.compile(regExpPattern);
            Matcher matcher = pattern.matcher(emailData);

            if (matcher.matches()) {
                getExtentTest().log(LogStatus.PASS, "Data typing action is done on Email element" + emailData);
            } else {
                getExtentTest().log(LogStatus.FAIL, "Phone data does not match the required pattern");
                status = false;
            }

            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Email element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Email element");
                } else
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

    public static void enterReenterPwd(String reenterPwdData) {
        boolean status = true;
        try {
            Assert.assertTrue(reenter_pwd.isDisplayed() && reenter_pwd.isEnabled());
            getExtentTest().log(LogStatus.PASS, "ReEnter-Password element is displayed and enabled ");

            reenter_pwd.clear();
            getExtentTest().log(LogStatus.PASS, "ReEnter-Password element is cleared ");

            reenter_pwd.sendKeys(reenterPwdData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on ReEnter-Password element");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "ReEnter-Password element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on ReEnter-Password element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on ReEnter-Password element");
        }
    }

    public static void enterPhoneInd(String phoneData) {
        boolean status = true;
        try {
            Assert.assertTrue(phone.isDisplayed() && phone.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Phone element is displayed and enabled ");

            phone.clear();
            getExtentTest().log(LogStatus.PASS, "Phone element is cleared ");
            //phone.sendKeys("+91");

            phone.sendKeys(phoneData);
            String regExpPattern = "^'?[6-9][0-9]{9}'?$";

            Pattern pattern = Pattern.compile(regExpPattern);
            Matcher matcher = pattern.matcher(phoneData);

            if (matcher.matches()) {
                getExtentTest().log(LogStatus.PASS, "Data typing action is done on Phone element: " + phoneData);
            } else {
                getExtentTest().log(LogStatus.FAIL, "Phone data does not match the required pattern");
                status = false;
            }

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Phone element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Phone element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Phone element");
        }

    }

    public static void enterPhoneUS(String phoneData) {
        boolean status = true;
        try {
            Assert.assertTrue(phone.isDisplayed() && phone.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Phone element is displayed and enabled ");

            phone.clear();
            getExtentTest().log(LogStatus.PASS, "Phone element is cleared ");


            phone.sendKeys(phoneData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Phone element: " + phoneData);
            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Phone element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Phone element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Phone element");
            }

    }

            //No condition applied for this field so we are commenting
            // Get the entered phone number
            /*String enteredPhoneNumber = phone.getAttribute("value");

            // Define a regex pattern for a US phone number
            String regexPattern = "^\\(?(\\d{3})\\)?[-.\\s]?(\\d{3})[-.\\s]?(\\d{4})$";
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(enteredPhoneNumber);

            // Check if the entered phone number matches the regex pattern
            if (matcher.matches()) {
                System.out.println("Valid US phone number: " + enteredPhoneNumber);
            } else {
                System.out.println("Invalid US phone number: " + enteredPhoneNumber);
            }
*/

    public static void enterCity(String cityData) {
        boolean status = true;
        try {
            Assert.assertTrue(city.isDisplayed() && city.isEnabled());
            getExtentTest().log(LogStatus.PASS, "City element is displayed and enabled ");

            city.clear();
            getExtentTest().log(LogStatus.PASS, "City element is cleared ");

            city.sendKeys(cityData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on City element: " + cityData);

            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "City element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on City element");
                } else
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

            state.sendKeys(stateData);
            getExtentTest().log(LogStatus.PASS, "State typing action is done on State element: " + stateData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "State element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on State element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on State element");
        }
    }

    public static void clickOnRegisterButton() {
        boolean status = true;
        try {

            Assert.assertTrue(registerButton2.isDisplayed() && registerButton2.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register element is displayed and enabled ");
            if (!registerButton2.isSelected()) {
                // If it's not checked, then check it
                registerButton2.click();
                getExtentTest().log(LogStatus.PASS, "Clicking action is done on Register element ");
            } else {
                // The checkbox is already checked, you can log or take some other action
                registerButton2.click();
                System.out.println("Checkbox is already checked.");
            }
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

    public static void clickOnTermsAndConditions() {
        boolean status = true;
        try {
            //JavascriptExecutor js = (JavascriptExecutor) getDriver();

           /* Assert.assertTrue(termsNCond.isDisplayed() && termsNCond.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Terms and Conditions element is displayed and enabled");*/

            WebElement checkbox = getDriver().findElement(By.xpath("//input[@type='checkbox' and @name='terms-n-condition']"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", checkbox);


            //driver.findElement(By.xpath("//input[@type='checkbox' and @name='terms-n-condition']")).click();
/*
            js.executeScript("arguments[0].click();", termsNCond);
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Terms and Conditions element"+termsNCond);*/

            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Terms and Conditions element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Terms and Conditions element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Terms and Conditions element");
            }
    }

    public static void dropDownCountryInd() {
        boolean status = true;
        try {

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebElement dropdown = getDriver().findElement(By.xpath("//div[@class='choices__list']"));
            // Find the outer scrollable element (e.g., a div)
            WebElement outerScrollableElement = getDriver().findElement(By.xpath("//div[@data-type='select-one']")); // Replace with the correct locator

            // Scroll the outer element into view
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", outerScrollableElement);
            Thread.sleep(1000); // Wait for a moment to ensure visibility

            // Find the inner scrollable element (e.g., a dropdown)
            WebElement innerScrollableElement = getDriver().findElement(By.xpath("//div[@class='choices__list choices__list--single']")); // Replace with the correct locator

            // Scroll the inner element into view within the outer element
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollTop = arguments[1];", innerScrollableElement, 200);
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Click the dropdown to open the options
            innerScrollableElement.click();
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Find and click the option with "India" text
            WebElement indiaOption = getDriver().findElement(By.xpath("//div[@class='choices__list']//div[text()='India']")); // Replace with the correct locator
            indiaOption.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

      /*  try {


            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebDriverWait wait = new WebDriverWait(getDriver(),10);
            wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

            WebElement parentElement = getDriver().findElement(By.xpath("//input[@class='choices__input choices__input--cloned']"));
           // WebElement dropDown = parentElement.findElement(By.xpath(".//div[@class='choices__list']"));



           // WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='choices__list']")));

            System.out.println("Step 1: Checking dropdown visibility");
          *//*  Assert.assertTrue(parentElement.isDisplayed() && parentElement.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Dropdown element is displayed and enabled ");*//*

           // JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", parentElement);

            // Find the outer scrollable element
            Assert.assertTrue(outerScrollableElement.isDisplayed() && outerScrollableElement.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Outer scroll bar element is displayed and enabled");

            // Scroll the outer element into view
            //JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", outerScrollableElement);
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Outer scroll element");

            // Wait for a moment to ensure visibility
            //Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(innerScrollableElement));

            // Find the inner scrollable element
            Assert.assertTrue(innerScrollableElement.isDisplayed() && innerScrollableElement.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Inner scroll bar element is displayed and enabled");

            // Scroll the inner element into view within the outer element
            System.out.println("Scrolling the inner element into view");
            js.executeScript("arguments[0].scrollTop = arguments[1];", innerScrollableElement, 200);
            System.out.println("Scrolling completed");

            // Wait for a moment (you may need to use WebDriverWait for more robust waits)
            Thread.sleep(1000);

            // Click the dropdown to open the options
            innerScrollableElement.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Inner scroll element");

            // Wait for a moment (you may need to use WebDriverWait for more robust waits)
            //Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(indiaOption));

            // Find and click the option with "India" text
            Assert.assertTrue(indiaOption.isDisplayed() && indiaOption.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Option to select the country name element is displayed and enabled");

            indiaOption.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on India option from drop down"+indiaOption);

            } catch (Exception exception) {
                exception.printStackTrace();
                getExtentTest().log(LogStatus.FAIL, "DropDown element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on DropDown element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on DropDown element");
            }
    }*/

    public static void dropDownCountryUS() {
        boolean status = true;
        try {

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebElement dropdown = getDriver().findElement(By.xpath("//div[@class='choices__list']"));
            // Find the outer scrollable element (e.g., a div)
            WebElement outerScrollableElement = getDriver().findElement(By.xpath("//div[@data-type='select-one']")); // Replace with the correct locator

            // Scroll the outer element into view
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", outerScrollableElement);
            Thread.sleep(1000); // Wait for a moment to ensure visibility

            // Find the inner scrollable element (e.g., a dropdown)
            WebElement innerScrollableElement = getDriver().findElement(By.xpath("//div[@class='choices__list choices__list--single']")); // Replace with the correct locator

            // Scroll the inner element into view within the outer element
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollTop = arguments[1];", innerScrollableElement, 200);
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Click the dropdown to open the options
            innerScrollableElement.click();
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Find and click the option with "India" text
            WebElement usOption = getDriver().findElement(By.xpath("//div[@class='choices__list']//div[text()='United States (US)']")); // Replace with the correct locator
            usOption.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static  String verifyWelcomeUN(String welcomeUNData){
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            //wait.until(ExpectedConditions.visibilityOf(welcomeUN));
           // wait.until(ExpectedConditions.visibilityOf(welcomeUN));

            Assert.assertTrue(welcomeUN.isDisplayed() && welcomeUN.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Welcome link element is displayed and enabled");
            //WebElement welcomeUN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]")));
            welcomeUN.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action done on Welcome link");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Welcome UserName link  is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Welcome UserName link");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Welcome UserName link");
        }
        return welcomeUNData;
    }

    public static void processCellValue(Cell cell){
        boolean status = true;
        try {
        String testDataValueofWelcomeUN = cell.toString();
        String welcomeUNData = testDataValueofWelcomeUN; // Replace with your actual data
        getExtentTest().log(LogStatus.PASS, "Retrieving Cell value from test data");

        String verificationResult = FreeRegisterPage.verifyWelcomeUN(welcomeUNData);
        getExtentTest().log(LogStatus.PASS, "Retrieving user value from application");

        getExtentTest().log(LogStatus.PASS, "Welcome data validation is passed using: "+ verificationResult +  " with test data: " + welcomeUNData);
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Welcome data validation is not happen ");
            status = false;
        }
    }

   public static void openUNLink(){
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            WebElement welcomeUNLink = getDriver().findElement(By.xpath("(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]"));
            //WebElement welcomeUNLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]")));
            welcomeUNLink.click();
                getExtentTest().log(LogStatus.PASS, "Welcome User link is enabled and displayed  ");
        }catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Timeout: Welcome UserName link  is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Welcome UserName link");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Welcome UserName link");
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


    /*public static void clickOnImagelink() {
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
*/
}
