package com.jkyog.automation.utilities;

import com.jkyog.automation.base.BaseTest;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ScreenshotClass extends BaseTest {
    public static void main(String[] args) throws IOException {

        TakesScreenshot driver = (TakesScreenshot) getDriver();

        // Create an instance of ScreenshotUtilityImpl
        ScreenshotUtility screenshotUtility = new ScreenshotUtilityImpl(driver);

        // Call the takesScreenshot method
        String screenshotPath = screenshotUtility.takesScreenshot("TestCase1");

        // Do something with the screenshotPath if needed
        System.out.println("Screenshot saved at: " + "C:\\Users\\HP\\IdeaProjects\\JKYog\\Screenshots");
            }
}