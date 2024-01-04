package threeyrmembership.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.jkyog.automation.freeregister.pageobjects.FreeRegisterPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ThreeyrMembershipPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), FreeRegisterPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//span[@class='elementor-icon-list-text' and text() = 'Register']")
    private static WebElement registerLink;

    @FindBy(xpath = "//span[@class= 'elementor-button-text' and text()='Pay in INR'][1]")
    private static WebElement payINR_ThreeYr;


    public static void clickOnRegisterlink_ThreeYrMbr() {
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
}
