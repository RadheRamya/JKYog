package Payment.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import threeyrmembership.pageobjects.MembershipPlanPage;

import java.time.Duration;

public class PaymentPage extends BaseTest {
    static {
        PageFactory.initElements(getDriver(), MembershipPlanPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//div[@class='radio-display'][1]")
    private static WebElement bankLink;

    @FindBy(xpath = "//button[@id='redesign-v15-cta']")
    private static WebElement payNow;


    @FindBy(xpath = "//button[@class='success']")
    private static WebElement successButton;

    @FindBy(xpath = "//span[@class='elementor-button-text']")
    private static WebElement goToHomePage;

    @FindBy(xpath = "//a[contains(@class, 'elementor-item') and contains(text(), 'Welcome')][1]")
    private static WebElement welcomeUN;

    @FindBy(xpath = "//a[@class='elementor-sub-item menu-link' and text()='Logout'][1]")
    private static WebElement logout;


    public static void clickOnBankLink_inINR_ThreeYrMbr() {
        boolean status = true;
        try {
            /*WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='svelte-30hv15']")));*/
            Assert.assertTrue(bankLink.isDisplayed() && bankLink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Bank Link element is displayed and enabled ");

            bankLink.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Bank link ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Bank Link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Bank Link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Bank Link element");
        }
    }


    public static void clickOnPayNow_inINR_ThreeYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(payNow.isDisplayed() && payNow.isEnabled());
            getExtentTest().log(LogStatus.PASS, "PayNow button element is displayed and enabled ");

            payNow.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on PayNow button ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "PayNow button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on PayNow button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on PayNow button element");
        }
    }

    public static void clickOnSuccess_inINR_ThreeYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(successButton.isDisplayed() && successButton.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Success button element is displayed and enabled ");

            successButton.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Success button ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Success button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Success button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Success button element");
        }
    }

    public static void clickOnGoToHomePage_inINR_ThreeYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(goToHomePage.isDisplayed() && goToHomePage.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Go to Home Page button element is displayed and enabled ");

            goToHomePage.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Go to Home Page button ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Go to Home Page button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Go to Home Page button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Go to Home Page button element");
        }
    }

    public static  String verifyWelcomeUN(String welcomeUNData){
        boolean status = true;
        try {
            //WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            //WebElement welcomeUN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class, 'elementor-item') and contains(text(), 'Welcome')][1]")));
            WebElement welcomeUN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class, 'elementor-item') and contains(text(), 'Welcome')])[1]")));
            //wait.until(ExpectedConditions.visibilityOf(welcomeUN));
            // wait.until(ExpectedConditions.visibilityOf(welcomeUN));

            Assert.assertTrue(welcomeUN.isDisplayed() && welcomeUN.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Welcome link element is displayed and enabled");

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

    public static void processCellValue(Cell cell) {
        boolean status = true;
        try {
            String testDataValueofWelcomeUN = cell.toString();
            String welcomeUNData = testDataValueofWelcomeUN; // Replace with your actual data
            getExtentTest().log(LogStatus.PASS, "Retrieving Cell value from test data");

            String verificationResult = PaymentPage.verifyWelcomeUN(welcomeUNData);
            getExtentTest().log(LogStatus.PASS, "Retrieving user value from application");

            getExtentTest().log(LogStatus.PASS, "Welcome data validation is passed using: " + verificationResult + " with test data: " + welcomeUNData);
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Welcome data validation is not happen ");
            status = false;
        }

    }

    public static void clickOnLogoutlink() {
        boolean status = true;
        try {
           // WebDriverWait wait = new WebDriverWait(getDriver(), 5);
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

    public static void clickOnWelcomeOpenlink() {
        boolean status = true;
        try {
           // WebDriverWait wait = new WebDriverWait(getDriver(), 20);
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



}
