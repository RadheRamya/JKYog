package com.jkyog.automation.listeners;

import com.jkyog.automation.utilities.ScreenshotUtility;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class TestCaseActivityAdapter extends TestListenerAdapter {
    private ScreenshotUtility screenshotUtility;

    public TestCaseActivityAdapter(ScreenshotUtility screenshotUtility) {
        this.screenshotUtility = screenshotUtility;
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Case is Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case is failed: " + result.getName());
        try {
            screenshotUtility.takesScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case is skipped: " + result.getName());
        try {
            screenshotUtility.takesScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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