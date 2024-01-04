package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.customizedexceptions.FrameworkException;
import com.jkyog.automation.freeregister.pageobjects.LogoutPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTest extends ActionEngine {
    @Test
    public void logoutTest() throws IOException, FrameworkException {

        //LogoutPage.clickOnOpenArrow();
        LogoutPage.clickOnWelcomeOpenlink();
        LogoutPage.clickOnLogoutlink();
        LogoutPage.clickOnImagelink();

    }

}
