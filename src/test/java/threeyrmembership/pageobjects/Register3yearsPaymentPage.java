package threeyrmembership.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register3yearsPaymentPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), Register3yearsPaymentPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//input[@id='ff_10_names_first_name_']")
    private static WebElement firstName;

    @FindBy(id = "ff_10_names_last_name_")
    private static WebElement lastName;

    @FindBy(id = "ff_10_input_text")
    private static WebElement userName;

    @FindBy(id = "ff_10_email")
    private static WebElement email;

    @FindBy(id = "ff_10_password")
    private static WebElement password;

    @FindBy(id = "ff_10_password_2")
    private static WebElement reenter_pwd;

    @FindBy(id = "ff_10_phone")
    private static WebElement phone;

    @FindBy(id = "ff_10_city")
    private static WebElement city;

    @FindBy(id = "ff_10_state")
    private static WebElement state;

    @FindBy(id = "ff_10_country-list")
    private static WebElement country;

    @FindBy(xpath = "//input[@type='checkbox' and @name='terms-n-condition']")
    private static WebElement termsNCond;

    @FindBy(xpath = "//button[text()='Register']")
    private static WebElement registerButton2;

    @FindBy(id = "cardNumber")
    private static WebElement cardNumber;

    @FindBy(id = "cardExpiry")
    private static WebElement cardExpiry;

    @FindBy(id = "cardCvc")
    private static WebElement cardCVC;

    @FindBy(id = "billingName")
    private static WebElement cardHolderName;

    @FindBy(id = "billingPostalCode")
    private static WebElement zipcode;

    @FindBy(xpath = "//div[@class='SubmitButton-IconContainer']")
    private static WebElement pay;

    @FindBy(xpath = "//span[@class='elementor-button-text']")
    private static WebElement goToHomePage;


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
        public static void enterCity (String cityData){
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

        public static void enterState (String stateData){
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

        public static void clickOnRegisterButton () {
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

        public static void clickOnTermsAndConditions () {
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

    public static void validateCountryInd() {
        boolean status = true;
        try {
            //String selectedCountry = country.getText(); // Assuming country is a dropdown WebElement

            // Check if the default selected country is "India"
            Select countryDropdown = new Select(getDriver().findElement(By.xpath("//select[@id='ff_4_country-list']")));
            String selectedCountry = countryDropdown.getFirstSelectedOption().getText().trim();
            if ("India".equals(selectedCountry.trim())) {
                getExtentTest().log(LogStatus.PASS, "Country name India is selected on Country element ");
                System.out.println("Selected Country: " + selectedCountry.trim());
            } else {
                System.out.println("Country name India is not selected on Country element");
                status = false;
            }
        } catch (Exception e) {
            // Handle any exceptions that might occur during validation
            System.out.println("Exception occurred: " + e.getMessage());
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Country element");
            } else {
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Country element");
            }
        }
    }

    public static void validateCountryUS() {
        boolean status = true;
        try {

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            //WebElement dropdown = getDriver().findElement(By.xpath("//div[@class='choices__list']"));
            WebElement dropdown = getDriver().findElement(By.xpath("//select[@id='ff_10_country-list']"));

            /*// Find the outer scrollable element (e.g., a div)
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
*/
            // Find and click the option with "India" text
            WebElement usOption = getDriver().findElement(By.xpath("//option[text()='United States (US)']")); // Replace with the correct locator
            usOption.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void enterCardNumber(String cardNumberData) {
        boolean status = true;
        try {
            Assert.assertTrue(cardNumber.isDisplayed() && cardNumber.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Firstname element is displayed and enabled ");

            cardNumber.clear();
            getExtentTest().log(LogStatus.PASS, "Firstname element is cleared ");

            cardNumber.sendKeys(cardNumberData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element: " + cardNumber);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Card Number element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Card Number element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Card Number element");
        }
    }

    public static void entercardExpiry(String cardExpiryData) {
        boolean status = true;
        try {
            Assert.assertTrue(cardExpiry.isDisplayed() && cardExpiry.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Card Expiry element is displayed and enabled ");

            cardExpiry.clear();
            getExtentTest().log(LogStatus.PASS, "Card Expiry element is cleared ");

            cardExpiry.sendKeys(cardExpiryData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Card Expiry element" + cardExpiry);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Card Expiry element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Card Expiry element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Card Expiry element");
        }
    }

    public static void enterCardCVC(String cardCVCData) {
        boolean status = true;
        try {
            Assert.assertTrue(cardCVC.isDisplayed() && cardCVC.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Card CVC element is displayed and enabled ");

            cardCVC.clear();
            getExtentTest().log(LogStatus.PASS, "Card CVC element is cleared ");

            cardCVC.sendKeys(cardCVCData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Card CVC element" + cardCVCData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Card CVC element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Card CVC element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Card CVC element");
        }
    }


    public static void enterCardHolderName(String cardHolderNameData) {
        boolean status = true;
        try {
            Assert.assertTrue(cardHolderName.isDisplayed() && cardHolderName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Card Holder Name element is displayed and enabled ");

            cardHolderName.clear();
            getExtentTest().log(LogStatus.PASS, "Card Holder Name  element is cleared ");

            cardHolderName.sendKeys(cardHolderNameData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Card Holder Name  element" + cardHolderNameData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Card Holder Name  element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Card Holder Name  element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Card Holder Name  element");
        }
    }

    public static void enterzipcode(String zipcodeData) {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            Assert.assertTrue(zipcode.isDisplayed() && zipcode.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Zipcode element is displayed and enabled ");

            zipcode.clear();
            getExtentTest().log(LogStatus.PASS, "Zipcode element is cleared ");

            zipcode.sendKeys(zipcodeData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Zipcode element" + zipcodeData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Zipcode element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Zipcode element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Zipcode element");
        }
    }

    public static void dropDownCountryUS() {
        boolean status = true;
        try {

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebElement dropdown = getDriver().findElement(By.id("billingCountry"));

            WebElement usOption = getDriver().findElement(By.xpath("//div[@class='Select']//option[text()='United States']")); // Replace with the correct locator
            usOption.click();
            } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static void clickOnPayButton () {
        boolean status = true;
        try {

            Assert.assertTrue(pay.isDisplayed() && pay.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Pay element is displayed and enabled ");
            if (!pay.isSelected()) {
                // If it's not clicked, then click it
                pay.click();
                getExtentTest().log(LogStatus.PASS, "Clicking action is done on Pay element ");
            } else {
                // The button is already clicked, you can log or take some other action
                pay.click();
                System.out.println("Pay button is already checked.");
            }
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Pay element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Pay element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Pay element");
        }
      }

    public static void clickOnGoToHomePage () {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            //WebElement welcomeUN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class, 'elementor-item') and contains(text(), 'Welcome')][1]")));
            WebElement gotoHomePage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='elementor-button-text']")));
            Assert.assertTrue(gotoHomePage1.isDisplayed() && gotoHomePage1.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Go to Homepage element is displayed and enabled ");
            if (!gotoHomePage1.isSelected()) {
                // If it's not clicked, then click it
                gotoHomePage1.click();
                getExtentTest().log(LogStatus.PASS, "Clicking action is done on Go to Homepage element ");
            } else {
                // The button is already clicked, you can log or take some other action
                gotoHomePage1.click();
                System.out.println("Go to Homepage button is already clicked.");
            }
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Go to Homepage element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Go to Homepage element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Go to Homepage element");
        }
    }
    }

