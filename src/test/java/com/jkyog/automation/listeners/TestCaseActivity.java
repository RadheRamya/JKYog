package com.jkyog.automation.listeners;

import com.jkyog.automation.utilities.ScreenshotUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestCaseActivity implements ITestListener{

    private ScreenshotUtility screenshotUtility;

    public TestCaseActivity(ScreenshotUtility screenshotUtility) {
        this.screenshotUtility = screenshotUtility;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case is Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case is failed: " + result.getName());
        String tcName = result.getName();
        String imagePath = screenshotUtility.takesScreenshot(tcName);
        // Use imagePath as needed
        System.out.println("Screenshot saved at: " + imagePath);
        /*try {
            String tcName = result.getName();
            String imagePath = screenshotUtility.takesScreenShot(tcName);
            // Use imagePath as needed
            System.out.println("Screenshot saved at: " + imagePath);
        } catch (IOException e) {
            throw new RuntimeException(e);*/
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case is skipped: " + result.getName());
        String tcName = result.getName();
        String imagePath = screenshotUtility.takesScreenshot(tcName);
        // Use imagePath as needed
        System.out.println("Screenshot saved at: " + imagePath);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implementation if needed
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Implementation if needed
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TC is started");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite execution is started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite execution is completed");
    }

}

   /* @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Case is Passed: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case is failed: "+result.getName());
        try {
            String tcName = result.getName();
            String imagePath = ScreenshotUtility.takesScreenShot(tcName);
            // Use imagePath as needed
            System.out.println("Screenshot saved at: " + imagePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case is skipped: " + result.getName());
        System.out.println("Test Case is failed: " + result.getName());
        try {
            String tcName = result.getName();
            String imagePath = ScreenshotUtility.takesScreenShot(tcName);
            // Use imagePath as needed
            System.out.println("Screenshot saved at: " + imagePath);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("TC is started");
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Suite execution is started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite execution is completed");
    }
}
*/