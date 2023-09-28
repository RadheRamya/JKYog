package com.jkyog.automation.utilities;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public interface ScreenshotUtility
{

    public static String takesScreenShot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = System.getProperty("user.dir") + "\\Screnshots\\" + BaseTest.getTcName() + ".jpeg";
        FileUtils.copyFile(file, new File(imagePath));
        return imagePath;
    }

    public static String takesScreenShot(String tcName) throws IOException
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = System.getProperty("user.dir") + "\\Screnshots\\" + tcName + ".jpeg";
        FileUtils.copyFile(file, new File(imagePath));
        return imagePath;
    }


}