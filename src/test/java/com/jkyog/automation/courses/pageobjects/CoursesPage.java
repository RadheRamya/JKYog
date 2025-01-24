package com.jkyog.automation.courses.pageobjects;

import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CoursesPage extends BaseTest {

    static {
        PageFactory.initElements(getDriver(), CoursesPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "(//a[@class='elementor-item menu-link' and text() = 'Courses'])[1]")
    private static WebElement coursesLink;

    @FindBy(xpath = "//div[@class='tutor-ratio tutor-ratio-16x9']")
    private static WebElement coursesList;

    @FindBy(xpath = "//a[@class='tutor-btn tutor-btn-outline-primary tutor-btn-md tutor-btn-block ' and normalize-space(text())='Continue Learning']")
    private static WebElement continueLearningButtton;

    @FindBy(xpath = "//a[@class='tutor-btn tutor-btn-outline-primary tutor-btn-md tutor-btn-block ' and normalize-space(text())='Start Learning']")
    private static WebElement startLearningButton;

    @FindBy(xpath = "//a[@class='page-numbers']")
    private static WebElement pageNumbers;

    @FindBy(id = "paid")
    private static WebElement paidCheckbox;

    @FindBy(xpath = "//a[@data-lesson-id='26956']")
    private static WebElement lessson1_Session1;

    @FindBy(xpath = "//button[@data-plyr='play'][1]")
    private static WebElement playButton;


    @FindBy(xpath = "//input[@data-plyr='seek']")
    private static WebElement playProgress;




     public static void clickOnCoursesLink() {
        boolean status = true;
         WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(coursesLink));
            Assert.assertTrue(coursesLink.isDisplayed() && coursesLink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Courses link element is displayed and enabled ");

            coursesLink.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Courses link element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Courses link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Courses link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Courses link element");
        }
    }

    public static void clickOnPaidCheckbox() {
        boolean status = true;
        try {
            Assert.assertTrue(paidCheckbox.isDisplayed() && paidCheckbox.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Paid checkbox element is displayed and enabled ");

            paidCheckbox.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Paid checkbox element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Paid checkbox element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Paid checkbox element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Paid checkbox element");
        }
    }

    public static void validate_StartorContinue_Learningbutton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(coursesList));

        try {
            boolean allCoursesValid = true;

            // Iterate through each course on the first page
            validateCoursesOnPage();

            // Click on the page number for the second page
            //WebElement pageNumber2 = getDriver().findElement(By.xpath("//div[@class='pagenumbers']//a[text()='2']"));
            pageNumbers.click();

            // Wait for the courses list on the second page
            wait.until(ExpectedConditions.visibilityOf(coursesList));

            // Iterate through each course on the second page
            validateCoursesOnPage();

            if (allCoursesValid) {
                getExtentTest().log(LogStatus.PASS, "Start Learning or Continue Learning buttons is displayed for all courses on both pages");
                getExtentTest().log(LogStatus.PASS, "Course List is displayed on both pages");
            } else {
                getExtentTest().log(LogStatus.FAIL, "Neither Start Learning nor Continue Learning button is displayed for one or more courses on both pages");
                getExtentTest().log(LogStatus.FAIL, "Course List is NOT displayed on both pages");
            }
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Error occurred during validation: " + exception.getMessage());
        }
    }

    private static void validateCoursesOnPage() {
        // Iterate through each course on the current page
        for (WebElement course : coursesList.findElements(By.xpath(".//div[@class='tutor-ratio tutor-ratio-16x9']"))) {
            // Find 'Start Learning' button within the course
            WebElement startLearningButton = course.findElement(By.xpath(".//a[@class='tutor-btn tutor-btn-outline-primary tutor-btn-md tutor-btn-block ' and text() = 'Start Learning']"));

            // Find 'Continue Learning' button within the course
            WebElement continueLearningButton = course.findElement(By.xpath(".//a[@class='tutor-btn tutor-btn-outline-primary tutor-btn-md tutor-btn-block ' and text() = 'Continue Learning']"));

            // Validate the presence of at least one button for each course
            if (startLearningButton.isDisplayed() || continueLearningButton.isDisplayed()) {
                getExtentTest().log(LogStatus.PASS, "At least one of the buttons is displayed for the course");
            } else {
                getExtentTest().log(LogStatus.FAIL, "Neither Start Learning nor Continue Learning button is displayed for the course");
                boolean allCoursesValid = false;
            }
        }
    }

    public static void clickOnPageNumber(int pageNumber) {
        // Assuming pageNumbers represents the container of page numbers
        WebElement specificPageNumber = pageNumbers;
        getExtentTest().log(LogStatus.PASS, "Pagenumbers are displayed on both pages");
        // Click on the specific page number
        specificPageNumber.click();
        getExtentTest().log(LogStatus.PASS, "Clicking action done on specific pagenumber link");
    }

    public static void clickOnStartLearningButton() {
        boolean status = true;
        try {
            Assert.assertTrue(startLearningButton.isDisplayed() && startLearningButton.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Start Learning button element is displayed and enabled ");

            startLearningButton.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Start Learning button element");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Start Learning button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Start Learning button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Start Learning button element");
        }
    }

    public static void clickOnStartOrContinueLearningButton() {
        boolean status = true;

        try {
            WebElement buttonToClick = null;

            // Check if Start Learning button is displayed and enabled
            if (continueLearningButtton.isDisplayed() && continueLearningButtton.isEnabled()) {
                buttonToClick = continueLearningButtton;
            } else if (startLearningButton.isDisplayed() && startLearningButton.isEnabled()) {
                // Check if Continue Learning button is displayed and enabled
                buttonToClick = startLearningButton;
            } else {
                throw new NoSuchElementException("Neither Start Learning nor Continue Learning button is displayed and enabled");
            }

            getExtentTest().log(LogStatus.PASS, buttonToClick.getText() + " button element is displayed and enabled");

            buttonToClick.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on " + buttonToClick.getText() + " button element");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Neither Start Learning nor Continue Learning button is displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on either Start Learning or Continue Learning button element");
            } else {
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on either Start Learning or Continue Learning button element");
            }
        }
    }

    public static void clickOnLessons_Session1() {
        boolean status = true;
        try {
            Assert.assertTrue(lessson1_Session1.isDisplayed() && lessson1_Session1.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Lesson1 for Session1 under course is displayed and enabled ");

            lessson1_Session1.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Lesson1 for Session1 under course");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Lesson1 for Session1 under course is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Lesson1 for Session1 under course");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Lesson1 for Session1 under course");
        }
    }

    public static void clickOnPlayButton() {
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            Assert.assertTrue(playButton.isDisplayed() && playButton.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Play button element is displayed and enabled ");

            playButton.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Play button element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Play button element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Play button element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Play button element");
        }
    }

       public static void moveCursorToEndOfVideo() {
        boolean status = true;

           try {
               // Extract the end time text
               WebElement endTimeElement = getDriver().findElement(By.xpath("//div[text()='-02:33']"));
               String endTimeText = endTimeElement.getText();

               // Parse the end time to get hours and minutes
               String[] timeParts = endTimeText.split(":");
               int hours = Integer.parseInt(timeParts[0]);
               int minutes = Integer.parseInt(timeParts[1]);

               // Calculate the total duration in seconds
               int totalDurationInSeconds = (hours * 60 + minutes) * 60;

               // Replace "your_video_element_xpath" with the actual XPath of the video element
               WebElement videoElement = playButton;

               // Calculate the xOffset based on the total duration
               int xOffset = (int) (videoElement.getSize().width * 0.95); // Adjust the percentage as needed

               // Create an instance of the Actions class
               Actions actions = new Actions(getDriver());

               // Move the cursor to the end of the video
               actions.moveToElement(videoElement, xOffset, 0).build().perform();

               System.out.println("Cursor moved to the end of the video");

           } catch (Exception exception) {
               System.err.println("Error occurred: " + exception.getMessage());
           }
       }
}

           /*try {
               // Ensure the playProgress is displayed and enabled
               WebDriverWait wait = new WebDriverWait(getDriver(), 10);
               WebElement visiblePlayProgress = wait.until(ExpectedConditions.visibilityOf(playProgress));
               Assert.assertTrue(visiblePlayProgress.isEnabled());

               getExtentTest().log(LogStatus.PASS, "Play progress element is displayed and enabled");

               Actions actions = new Actions(getDriver());

               // Move the cursor to the end of the video
               actions.moveToElement(playButton).build().perform();

               System.out.println("Cursor moved to the end of the video");

           } catch (Exception exception) {
               System.err.println("Error occurred: " + exception.getMessage());

               // Adjust the xOffset to place the cursor near the end but not completely at the end
                *//*JavascriptExecutor js = (JavascriptExecutor) getDriver();
               js.executeScript("arguments[0].scrollIntoView();", playProgress);*//*
               *//*int xOffset = (int) (visiblePlayProgress.getSize().width * 0.9);

               // Move the cursor to near the end of the video progress
               new Actions(getDriver())
                       .moveToElement(visiblePlayProgress, xOffset, 0)
                       .pause(500) // Introduce a small delay
                       .perform();*//*

               getExtentTest().log(LogStatus.PASS, "Cursor moved to near the end of the video progress");

           *//*} catch (Exception exception) {
               getExtentTest().log(LogStatus.FAIL, "Play progress element is NOT displayed and enabled");
               status = false;*//*
           } finally {
               if (status) {
                   getExtentTest().log(LogStatus.PASS, "Cursor moved to near the end of the video progress");
               } else {
                   getExtentTest().log(LogStatus.FAIL, "Cursor NOT moved to near the end of the video progress");
               }
           }
       }*/





    /*public static void clickOnRegisterButtonToFillDetails() {
        boolean status = true;
        try {
            Assert.assertTrue(registerButton1.isDisplayed() && registerButton1.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register button to fill details element is displayed and enabled ");

            registerButton1.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Register button to fill details element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Register button to fill details element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Register button to fill details button to fill details element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Register button to fill details element");
        }

    }

    public static void enterUserName(String unData) {
        boolean status = true;
        try {
            Assert.assertTrue(userName.isDisplayed() && userName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Username element is displayed and enabled ");

            userName.clear();
            getExtentTest().log(LogStatus.PASS, "Username element is cleared ");

            userName.sendKeys(unData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on UserName elememt");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "UserName elememt is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on UserName elememt");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on UserName elememt");
        }
    }


    public static void enterFirstName(String firstNameData) {
        boolean status = true;
        try {
            Assert.assertTrue(firstName.isDisplayed() && firstName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Firstname element is displayed and enabled ");

            firstName.clear();
            getExtentTest().log(LogStatus.PASS, "Firstname element is cleared ");

            firstName.sendKeys(firstNameData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element" + firstNameData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Firstname element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Firstname element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Firstname element");
        }
    }

    public static void enterLastName(String lastNameData) {
        boolean status = true;
        try {
            Assert.assertTrue(lastName.isDisplayed() && lastName.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Lastname element is displayed and enabled ");

            lastName.clear();
            getExtentTest().log(LogStatus.PASS, "Lastname element is cleared ");

            lastName.sendKeys(lastNameData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Firstname element" + lastNameData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Lastname element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Lastname element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Lastname element");
        }
    }

    public static void enterEmail(String emailData) {
        boolean status = true;
        try {
            Assert.assertTrue(email.isDisplayed() && email.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Email element is displayed and enabled ");

            email.clear();
            getExtentTest().log(LogStatus.PASS, "Email element is cleared ");

            email.sendKeys(emailData);
            String regExpPattern =  "^[A-Za-z0-9+_.-]+@(.+)$";//email
            Pattern pattern = Pattern.compile(regExpPattern);
            Matcher matcher = pattern.matcher(emailData);

            if (matcher.matches()) {
                getExtentTest().log(LogStatus.PASS, "Data typing action is done on Email element" + emailData);
            } else {
                getExtentTest().log(LogStatus.FAIL, "Phone data does not match the required pattern");
                status = false;
            }

            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Email element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Email element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Email element");
            }
        }

    public static void enterPassword(String passwordData) {
        boolean status = true;
        try {
            Assert.assertTrue(password.isDisplayed() && password.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Password element is displayed and enabled ");

            password.clear();
            getExtentTest().log(LogStatus.PASS, "Password element is cleared ");

            password.sendKeys(passwordData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Password element");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Password element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Password element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Password element");
        }
    }

    public static void enterReenterPwd(String reenterPwdData) {
        boolean status = true;
        try {
            Assert.assertTrue(reenter_pwd.isDisplayed() && reenter_pwd.isEnabled());
            getExtentTest().log(LogStatus.PASS, "ReEnter-Password element is displayed and enabled ");

            reenter_pwd.clear();
            getExtentTest().log(LogStatus.PASS, "ReEnter-Password element is cleared ");

            reenter_pwd.sendKeys(reenterPwdData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on ReEnter-Password element");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "ReEnter-Password element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on ReEnter-Password element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on ReEnter-Password element");
        }
    }

    public static void enterPhoneInd(String phoneData) {
        boolean status = true;
        try {
            Assert.assertTrue(phone.isDisplayed() && phone.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Phone element is displayed and enabled ");

            phone.clear();
            getExtentTest().log(LogStatus.PASS, "Phone element is cleared ");
            //phone.sendKeys("+91");

            phone.sendKeys(phoneData);
            String regExpPattern = "^'?[6-9][0-9]{9}'?$";

            Pattern pattern = Pattern.compile(regExpPattern);
            Matcher matcher = pattern.matcher(phoneData);

            if (matcher.matches()) {
                getExtentTest().log(LogStatus.PASS, "Data typing action is done on Phone element: " + phoneData);
            } else {
                getExtentTest().log(LogStatus.FAIL, "Phone data does not match the required pattern");
                status = false;
            }

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Phone element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Phone element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Phone element");
        }
*/
    /*}

    public static void enterPhoneUS(String phoneData) {
        boolean status = true;
        try {
            Assert.assertTrue(phone.isDisplayed() && phone.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Phone element is displayed and enabled ");

            phone.clear();
            getExtentTest().log(LogStatus.PASS, "Phone element is cleared ");


            phone.sendKeys(phoneData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on Phone element: " + phoneData);
            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Phone element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Phone element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Phone element");
            }

    }
*/
            //No condition applied for this field so we are commenting
            // Get the entered phone number
            /*String enteredPhoneNumber = phone.getAttribute("value");

            // Define a regex pattern for a US phone number
            String regexPattern = "^\\(?(\\d{3})\\)?[-.\\s]?(\\d{3})[-.\\s]?(\\d{4})$";
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(enteredPhoneNumber);

            // Check if the entered phone number matches the regex pattern
            if (matcher.matches()) {
                System.out.println("Valid US phone number: " + enteredPhoneNumber);
            } else {
                System.out.println("Invalid US phone number: " + enteredPhoneNumber);
            }
*/

    /*public static void enterCity(String cityData) {
        boolean status = true;
        try {
            Assert.assertTrue(city.isDisplayed() && city.isEnabled());
            getExtentTest().log(LogStatus.PASS, "City element is displayed and enabled ");

            city.clear();
            getExtentTest().log(LogStatus.PASS, "City element is cleared ");

            city.sendKeys(cityData);
            getExtentTest().log(LogStatus.PASS, "Data typing action is done on City element: " + cityData);

            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "City element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on City element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on City element");
            }
    }

    public static void enterState(String stateData) {
        boolean status = true;
        try {
            Assert.assertTrue(state.isDisplayed() && state.isEnabled());
            getExtentTest().log(LogStatus.PASS, "State element is displayed and enabled ");

            state.clear();
            getExtentTest().log(LogStatus.PASS, "State element is cleared ");

            state.sendKeys(stateData);
            getExtentTest().log(LogStatus.PASS, "State typing action is done on State element: " + stateData);

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "State element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on State element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on State element");
        }
    }
*/
/*    public static void clickOnRegisterButton() {
        boolean status = true;
        try {

            Assert.assertTrue(registerButton2.isDisplayed() && registerButton2.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Register element is displayed and enabled ");
            if (!registerButton2.isSelected()) {
                // If it's not checked, then check it
                registerButton2.click();
                getExtentTest().log(LogStatus.PASS, "Clicking action is done on Register element ");
            } else {
                // The checkbox is already checked, you can log or take some other action
                registerButton2.click();
                System.out.println("Checkbox is already checked.");
            }
            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Register element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Register element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Register element");
            }

    }

    public static void clickOnTermsAndConditions() {
        boolean status = true;
        try {
            //JavascriptExecutor js = (JavascriptExecutor) getDriver();

           *//* Assert.assertTrue(termsNCond.isDisplayed() && termsNCond.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Terms and Conditions element is displayed and enabled");*//*

            WebElement checkbox = getDriver().findElement(By.xpath("//input[@type='checkbox' and @name='terms-n-condition']"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", checkbox);


            //driver.findElement(By.xpath("//input[@type='checkbox' and @name='terms-n-condition']")).click();
*//*
            js.executeScript("arguments[0].click();", termsNCond);
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Terms and Conditions element"+termsNCond);*//*

            } catch (Exception exception) {
                getExtentTest().log(LogStatus.FAIL, "Terms and Conditions element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on Terms and Conditions element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Terms and Conditions element");
            }
    }

    public static void dropDownCountryInd() {
        boolean status = true;
        try {

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebElement dropdown = getDriver().findElement(By.xpath("//div[@class='choices__list']"));
            // Find the outer scrollable element (e.g., a div)
            WebElement outerScrollableElement = getDriver().findElement(By.xpath("//div[@data-type='select-one']")); // Replace with the correct locator

            // Scroll the outer element into view
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", outerScrollableElement);
            Thread.sleep(1000); // Wait for a moment to ensure visibility

            // Find the inner scrollable element (e.g., a dropdown)
            WebElement innerScrollableElement = getDriver().findElement(By.xpath("//div[@class='choices__list choices__list--single']")); // Replace with the correct locator

            // Scroll the inner element into view within the outer element
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollTop = arguments[1];", innerScrollableElement, 200);
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Click the dropdown to open the options
            innerScrollableElement.click();
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Find and click the option with "India" text
            WebElement indiaOption = getDriver().findElement(By.xpath("//div[@class='choices__list']//div[text()='India']")); // Replace with the correct locator
            indiaOption.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }*/

      /*  try {


            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebDriverWait wait = new WebDriverWait(getDriver(),10);
            wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

            WebElement parentElement = getDriver().findElement(By.xpath("//input[@class='choices__input choices__input--cloned']"));
           // WebElement dropDown = parentElement.findElement(By.xpath(".//div[@class='choices__list']"));



           // WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='choices__list']")));

            System.out.println("Step 1: Checking dropdown visibility");
          *//*  Assert.assertTrue(parentElement.isDisplayed() && parentElement.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Dropdown element is displayed and enabled ");*//*

           // JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", parentElement);

            // Find the outer scrollable element
            Assert.assertTrue(outerScrollableElement.isDisplayed() && outerScrollableElement.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Outer scroll bar element is displayed and enabled");

            // Scroll the outer element into view
            //JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", outerScrollableElement);
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Outer scroll element");

            // Wait for a moment to ensure visibility
            //Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(innerScrollableElement));

            // Find the inner scrollable element
            Assert.assertTrue(innerScrollableElement.isDisplayed() && innerScrollableElement.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Inner scroll bar element is displayed and enabled");

            // Scroll the inner element into view within the outer element
            System.out.println("Scrolling the inner element into view");
            js.executeScript("arguments[0].scrollTop = arguments[1];", innerScrollableElement, 200);
            System.out.println("Scrolling completed");

            // Wait for a moment (you may need to use WebDriverWait for more robust waits)
            Thread.sleep(1000);

            // Click the dropdown to open the options
            innerScrollableElement.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Inner scroll element");

            // Wait for a moment (you may need to use WebDriverWait for more robust waits)
            //Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(indiaOption));

            // Find and click the option with "India" text
            Assert.assertTrue(indiaOption.isDisplayed() && indiaOption.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Option to select the country name element is displayed and enabled");

            indiaOption.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on India option from drop down"+indiaOption);

            } catch (Exception exception) {
                exception.printStackTrace();
                getExtentTest().log(LogStatus.FAIL, "DropDown element is NOT displayed and enabled");
                status = false;
            } finally {
                if (status) {
                    getExtentTest().log(LogStatus.PASS, "Action is done on DropDown element");
                } else
                    getExtentTest().log(LogStatus.FAIL, "Action is NOT done on DropDown element");
            }
    }*/

    /*public static void dropDownCountryUS() {
        boolean status = true;
        try {

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            WebElement dropdown = getDriver().findElement(By.xpath("//div[@class='choices__list']"));
            // Find the outer scrollable element (e.g., a div)
            WebElement outerScrollableElement = getDriver().findElement(By.xpath("//div[@data-type='select-one']")); // Replace with the correct locator

            // Scroll the outer element into view
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", outerScrollableElement);
            Thread.sleep(1000); // Wait for a moment to ensure visibility

            // Find the inner scrollable element (e.g., a dropdown)
            WebElement innerScrollableElement = getDriver().findElement(By.xpath("//div[@class='choices__list choices__list--single']")); // Replace with the correct locator

            // Scroll the inner element into view within the outer element
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollTop = arguments[1];", innerScrollableElement, 200);
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Click the dropdown to open the options
            innerScrollableElement.click();
            Thread.sleep(1000); // Wait for a moment (you may need to use WebDriverWait for more robust waits)

            // Find and click the option with "India" text
            WebElement usOption = getDriver().findElement(By.xpath("//div[@class='choices__list']//div[text()='United States (US)']")); // Replace with the correct locator
            usOption.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static  String verifyWelcomeUN(String welcomeUNData){
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            //wait.until(ExpectedConditions.visibilityOf(welcomeUN));
           // wait.until(ExpectedConditions.visibilityOf(welcomeUN));

            Assert.assertTrue(welcomeUN.isDisplayed() && welcomeUN.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Welcome link element is displayed and enabled");
            //WebElement welcomeUN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]")));
            welcomeUN.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action done on Welcome link");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Welcome UserName link  is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Welcome UserName link");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Welcome UserName link");
        }
        return welcomeUNData;
    }

    public static void processCellValue(Cell cell){
        boolean status = true;
        try {
        String testDataValueofWelcomeUN = cell.toString();
        String welcomeUNData = testDataValueofWelcomeUN; // Replace with your actual data
        getExtentTest().log(LogStatus.PASS, "Retrieving Cell value from test data");

        String verificationResult = CoursesPage.verifyWelcomeUN(welcomeUNData);
        getExtentTest().log(LogStatus.PASS, "Retrieving user value from application");

        getExtentTest().log(LogStatus.PASS, "Welcome data validation is passed using: "+ verificationResult +  " with test data: " + welcomeUNData);
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Welcome data validation is not happen ");
            status = false;
        }
    }

   public static void openUNLink(){
        boolean status = true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            WebElement welcomeUNLink = getDriver().findElement(By.xpath("(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]"));
            //WebElement welcomeUNLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), 'Welcome') and @class='elementor-item elementor-item-anchor menu-link has-submenu'])[1]")));
            welcomeUNLink.click();
                getExtentTest().log(LogStatus.PASS, "Welcome User link is enabled and displayed  ");
        }catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Timeout: Welcome UserName link  is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Welcome UserName link");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Welcome UserName link");
        }
    }

    public static void clickOnLogoutlink() {
        boolean status = true;
        try {
            Assert.assertTrue(logout.isDisplayed() && logout.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Logout element is displayed and enabled ");

            logout.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Logout element ");

        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Logout element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Logout element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Logout element");
        }
    }*/


    /*public static void clickOnImagelink() {
        boolean status = true;
        try {
            Assert.assertTrue(imageLink.isDisplayed() && imageLink.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Image link element is displayed and enabled ");
            imageLink.click();
            getExtentTest().log(LogStatus.PASS, "Clicking action is done on Image link element ");
        } catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Image link element is NOT displayed and enabled");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Image link element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Image link element");
        }
    }
*/

