package com.jkyog.automation.utilities;

import java.io.IOException;

public interface ScreenshotUtility {
  String takesScreenShot() throws IOException;
    //static String takesScreenShot(String tcName) throws IOException;

    String takesScreenshot(String tcName);
}






