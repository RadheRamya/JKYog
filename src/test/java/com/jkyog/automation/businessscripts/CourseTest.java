package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.ActionEngine;
import com.jkyog.automation.courses.pageobjects.CoursesPage;
import org.testng.annotations.Test;

@Test
public class CourseTest extends ActionEngine {

    public void CourseTest() {
        CoursesPage.clickOnCoursesLink();
    }
}


