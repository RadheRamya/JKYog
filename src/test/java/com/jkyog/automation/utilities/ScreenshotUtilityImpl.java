package com.jkyog.automation.utilities;

import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ScreenshotUtilityImpl implements ScreenshotUtility {
    private final TakesScreenshot takesScreenshot;

    public ScreenshotUtilityImpl(TakesScreenshot takesScreenshot) {

        this.takesScreenshot = takesScreenshot;
    }

    @Override
    public String takesScreenShot() throws IOException {
        return null;
    }

    @Override
    public String takesScreenshot(String tcName) {
        // Your implementation here
        // Use takesScreenshot field to capture the screenshot
        // Return the file path or any relevant information
        return "Screenshot captured for " + tcName;
    }
}
/*public class ScreenshotUtilityImpl {

        private final TakesScreenshot takesScreenshot;

        public ScreenshotUtilityImpl(TakesScreenshot takesScreenshot) {
            this.takesScreenshot = takesScreenshot;
        }

        public String takesScreenShot(String tcName) throws IOException {
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String imagePath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + tcName + ".jpeg";
            FileUtils.copyFile(file, new File(imagePath));
            return imagePath;
        }
    }*/

    /*public final TakesScreenshot takesScreenshot;

    public ScreenshotUtility(TakesScreenshot takesScreenshot) {
        this.takesScreenshot = takesScreenshot;

    }

    public String takesScreenShot(String tcName) throws IOException {
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + tcName + ".jpeg";
        FileUtils.copyFile(file, new File(imagePath));
        return imagePath;
    }
}*/


   /* @Override
    public String takesScreenShot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + BaseTest.getTcName() + ".jpeg";
        FileUtils.copyFile(file, new File(imagePath));
        return imagePath;
    }

    @Override
    public String takesScreenShot(String tcName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseTest.getDriver();
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + tcName + ".jpeg";
        FileUtils.copyFile(file, new File(imagePath));
        return imagePath;
    }
}*/