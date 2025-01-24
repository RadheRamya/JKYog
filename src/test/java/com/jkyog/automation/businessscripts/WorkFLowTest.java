package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.workflow.pageobjects.WorkFLowPage;
import org.testng.annotations.Test;

public class WorkFLowTest extends ActionEngine {

    //private WebDriver driver;
    private WorkFLowPage workFlowPage;
 @Test
    public void WorkFlow() throws InterruptedException {

     WorkFLowPage.openCoursePage();
     WorkFLowPage.handleLearning();
     WorkFLowPage.rateAndWriteComment();
     WorkFLowPage.downloadCertificate();

 }
    }

