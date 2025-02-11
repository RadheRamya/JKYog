package threeyrmembership.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MembershipPlanPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), MembershipPlanPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath ="//a[@class='elementor-item menu-link' and contains(text(), 'Membership')][1]")
    private static WebElement membership;

    @FindBy(xpath = "//span[@class= 'elementor-button-text' and text()='Pay with INR'][1]")
    private static WebElement payINR_ThreeYr;

    @FindBy(xpath = "//span[@class='elementor-button-text' and text() = 'Pay with USD'][1]")
    private static WebElement payUSD_ThreeYr;

    @FindBy(xpath = "(//span[@class='elementor-button-text' and text()='Pay with INR'])[2]")
    private static WebElement payINR_OneYr;

    @FindBy(xpath = "(//span[@class='elementor-button-text' and text() = 'Pay with USD'])[2]")
    private static WebElement payUSD_OneYr;

    public static void clickMembershipLink() {
        boolean status = true;
        try {
            Assert.assertTrue(membership.isDisplayed() && membership.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Membership element is displayed and enabled ");

            membership.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Membership element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Membership element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Membership element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Membership element");
        }
    }



    public static void clickOnPay_inINR_ThreeYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(payINR_ThreeYr.isDisplayed() && payINR_ThreeYr.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Pay in INR element is displayed and enabled ");

            payINR_ThreeYr.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Pay in INR element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Pay in INR element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Pay in INR element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Pay in INR element");
        }
    }

    public static void clickOnPay_inUSD_ThreeYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(payUSD_ThreeYr.isDisplayed() && payUSD_ThreeYr.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Pay in USD element is displayed and enabled ");

            payUSD_ThreeYr.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Pay in USD element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Pay in USD element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Pay in USD element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Pay in USD element");
        }
    }

    public static void clickOnPay_inINR_OneYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(payINR_OneYr.isDisplayed() && payINR_OneYr.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Pay in INR element is displayed and enabled ");

            payINR_OneYr.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Pay in INR element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Pay in INR element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Pay in INR element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Pay in INR element");
        }
    }

    public static void clickOnPay_inUSD_OneYrMbr() {
        boolean status = true;
        try {
            Assert.assertTrue(payUSD_OneYr.isDisplayed() && payUSD_OneYr.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Pay in INR element is displayed and enabled ");

            payUSD_OneYr.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Pay in INR element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Pay in INR element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Pay in INR element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Pay in INR element");
        }
    }
}
