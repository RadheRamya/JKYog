package com.jkyog.automation.base;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

abstract public class ActionEngine extends BaseTest
{
    public static void entUrl(String url)
    {
        try{
           getDriver().get(url);
           getExtentTest().log(LogStatus.PASS, "Url is entered as: "+url);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Url is not entered as: "+url);
        }
    }

    public static void navigateUrl(String url)
    {
        try{
            getDriver().navigate().to(url);
            getExtentTest().log(LogStatus.PASS, "Url is entered as: "+url);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Url is not entered as: "+url);
        }
    }

    public static void DTA(WebElement element, String elementName, String testData)
    {
        try{
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            element.clear();
            getExtentTest().log(LogStatus.PASS, "Element is cleared: "+elementName);
            element.sendKeys(testData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void DTAByActions(WebElement element, String elementName, String testData)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.sendKeys(element,testData).build().perform();
            getExtentTest().log(LogStatus.PASS, "Data typing action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void DTAByActionsOne(WebElement element, String elementName, String testData)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.click(element).sendKeys(testData).build().perform();
            getExtentTest().log(LogStatus.PASS, "Data typing action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void DTAByJS(WebElement element, String elementName, String testData)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.click(element).sendKeys(testData).build().perform();
            getExtentTest().log(LogStatus.PASS, "Data typing action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void click(WebElement element, String elementName, String testData)
    {
        try{
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            element.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void clickByActions(WebElement element, String elementName, String testData)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.click(element).build().perform();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void clickByActionsOne(WebElement element, String elementName, String testData)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.doubleClick(element).build().perform();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }
    public static void clickByActionsByEnter(WebElement element, String elementName, String testData)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.sendKeys(element, Keys.ENTER).build().perform();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done element: "+elementName+ "with testdata as: "+ testData);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }


    public static void mouseHoverActions(WebElement element, String elementName)
    {
        try{
            Actions actions = new Actions(getDriver());
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+elementName);
            actions.moveToElement(element).build().perform();
            getExtentTest().log(LogStatus.PASS, "Mouse hover action is done element: "+elementName);
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+elementName);
        }
    }

    public static void handleDropDowns(WebElement element, String dropDownName, String how, String value)
    {
        try{
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+dropDownName);
            Select select = new Select(element);
            if(how.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            }
            else if (how.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            }
            else if (how.equalsIgnoreCase("index")) {
                int indx =Integer.parseInt(value);
                select.selectByIndex(indx);
            }
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+dropDownName);
        }
    }

    public static List<String> getTotalDropDownElements(WebElement element, String dropDownName)
    {
        List<String> dropDownValues = new ArrayList<String>();
        try{
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Element is displayed and enabled: "+dropDownName);
            Select select = new Select(element);
            List<WebElement> list = select.getAllSelectedOptions();
            for (WebElement element1 : list){
                String txt = element1.getText();
                dropDownValues.add(txt);
            }
        }
        catch(Exception exception){
            getExtentTest().log(LogStatus.FAIL, "Element is Not displayed and enabled: "+dropDownName);
        }
        return dropDownValues;
    }

    public static void handleMultipleWindows() {
        try {
            String currentWindow = getDriver().getWindowHandle();
            Set<String> windows = getDriver().getWindowHandles();
            getExtentTest().log(LogStatus.PASS, "Windows are: " + windows);
            if (windows.size() >= 1) {
                for (String str : windows) {
                    if (!str.equalsIgnoreCase(currentWindow)) {
                        getDriver().switchTo().window(str);
                        getExtentTest().log(LogStatus.PASS, "Switched to new Window: " + str);
                    }
                }
            } else {
                getExtentTest().log(LogStatus.PASS, "No Windows: " + windows);
            }
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Windows are: ");
        }
    }

        public static void handleMultipleWindows (int index){
            try {
                Set<String> windows = getDriver().getWindowHandles();
                getExtentTest().log(LogStatus.PASS, "Windows are: " + windows);
                List<String> listWindows = new ArrayList<String>(windows);
                if (windows.size() >= 1) {
                    String windowName = listWindows.get(index);
                    getDriver().switchTo().window(windowName);
                }
            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Windows are: ");
            }
        }
    }
