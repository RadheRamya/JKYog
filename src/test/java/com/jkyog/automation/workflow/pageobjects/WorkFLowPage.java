package com.jkyog.automation.workflow.pageobjects;


import com.jkyog.automation.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WorkFLowPage extends BaseTest {


    static {
        PageFactory.initElements(getDriver(), WorkFLowPage.class);
    }

    private static final JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//a[normalize-space(text()) = 'Start Learning']")
    private static List<WebElement> startLearningbtns;

    @FindBy(xpath = "//span[@class = 'tutor-icon-angle-right']")
    private static WebElement nextPageButton;


    @FindBy(xpath = "//div[@class='tutor-d-flex tutor-mr-32']")
    private static List<WebElement> lessons;

    @FindBy(xpath = "//*[@id='tutor-single-entry-content']/div[1]/div[2]/div[2]/form/button/span[2]")
    private static WebElement markAsCompleteButton;

    @FindBy(xpath = "(//div[@class='tutor-ratings-stars'])[3]")
    private static WebElement rating;

    @FindBy(xpath = "//textarea[@class='tutor-form-control tutor-mt-28']")
    private static WebElement comment;

    @FindBy(xpath = "//button[@class='tutor_submit_review_btn tutor-btn tutor-btn-primary tutor-ml-20']")
    private static WebElement updateReview;
    @FindBy(xpath = "//button[@id='tutor-pn-dont-ask']")
    private static WebElement notificationCloseBtn;

    @FindBy(xpath = "//ul[@id='menu-1-92c5f13']/li//a[@href ='https://staging72.courses.jkyog.org/courses/']")
    private static WebElement courseLink;

    @FindBy(xpath = "//input[@id='paid']")
    private static WebElement paid;

    @FindBy(xpath = "//a[contains(text(), 'Download Certificate')]")
    private static List<WebElement> downloadCertificateLinks;

    @FindBy(xpath = "//img[@id='tutor-pro-certificate-preview']")
    private static WebElement certificateImage;

    public static void openCoursePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        String[] urls = {
                "https://staging72.courses.jkyog.org/courses/roopdhyan-meditation/",
                "https://staging72.courses.jkyog.org/courses/roopdhyan-meditation-part-2/"
        };

        boolean buttonClicked = false;

        for (String url : urls) {
            getExtentTest().log(LogStatus.PASS, "Navigating to URL: " + url);
            if (checkButtonAvailability(url)) {
                buttonClicked = processURL(wait, url);
                if (buttonClicked) {
                    getExtentTest().log(LogStatus.PASS, "Button clicked on URL: " + url);
                    break;// Stop checking further URLs if the button is found and clicked
                }
            }
            handleNotification();
        }
        if (!buttonClicked) {
            getExtentTest().log(LogStatus.PASS, "No 'Start Learning' button found on any URL.");
        }
    }

    private static boolean checkButtonAvailability(String url) {
        try {
            getDriver().get(url);
            List<WebElement> startLearningButtons = startLearningbtns;
            return !startLearningButtons.isEmpty();
        } catch (TimeoutException e) {
            getExtentTest().log(LogStatus.PASS, "The list of 'Start Learning' buttons are empty");
            return false;
        }
    }

    private static boolean processURL(WebDriverWait wait, String url) {
        try {
            getDriver().get(url);
            getExtentTest().log(LogStatus.PASS, "Page loaded successfully: " + url);
            return processCoursePage(wait);
        } catch (TimeoutException e) {
            getExtentTest().log(LogStatus.PASS, "Failed to load page: " + url);
            return false;
        }
    }

    private static boolean processCoursePage(WebDriverWait wait) {
        boolean buttonFound = false;
        while (!buttonFound) {
            List<WebElement> startLearningButtons = startLearningbtns;
            for (int i = 0; i < startLearningButtons.size(); i++) {
                WebElement button = startLearningButtons.get(i);
                if (button.isDisplayed()) {
                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
                        getExtentTest().log(LogStatus.PASS, "Navigated to specific course.");
                        buttonFound = true;
                        break;
                    } catch (StaleElementReferenceException e) {
                        getExtentTest().log(LogStatus.PASS, "StaleElementReferenceException caught. Retrying...");
                    }
                } else {
                    getExtentTest().log(LogStatus.PASS, "Found 'Start Learning' button but it is not displayed.");
                }
            }
            if (buttonFound) {
                break;
            }
        }
        return buttonFound;
    }

    public static void handleLearning() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        // Dynamically find the count of all sections/lessons to iterate through
        List<WebElement> allLesson = lessons;
        int lessonCount = allLesson.size();
        getExtentTest().log(LogStatus.PASS, "Total lessons: " + lessonCount);

        // Iterate over each lesson
        for (int index = 0; index < lessonCount; index++) {
            // Re-find the lessons list and click on the current lesson based on index
            List<WebElement> allLessons = lessons;
            WebElement currentLesson = allLessons.get(index);
            currentLesson.click();

            // Wait for the "Mark as Complete" button to become available
            //WebElement markAsCompleteButton = null;
            try {
                wait.until(ExpectedConditions.elementToBeClickable(markAsCompleteButton));
            } catch (TimeoutException e) {
                // If the button is not available, assume the lesson is already marked
                getExtentTest().log(LogStatus.PASS, "Lesson " + (index + 1) + " is already marked.");
                continue; // Move to the next lesson
            }

            // Click the "Mark as Complete" button for this lesson
            try {
                Assert.assertTrue(markAsCompleteButton.isDisplayed() && markAsCompleteButton.isEnabled());
                markAsCompleteButton.click();
                getExtentTest().log(LogStatus.PASS, "Marked lesson " + (index + 1) + " as complete.");
                // Wait for a bit for the action to be processed
                Thread.sleep(500); // Consider using WebDriverWait instead of Thread.sleep for better reliability
            } catch (Exception e) {
                getExtentTest().log(LogStatus.PASS, "Could not click 'Mark as Complete' for lesson " + (index + 1) + ". Error: \" + e.getMessage()");
            }
        }
    }

    public static void handleNotification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            getExtentTest().log(LogStatus.PASS, "Attempting to find and click notification button...");
            wait.until(ExpectedConditions.elementToBeClickable(notificationCloseBtn));
            Assert.assertTrue(notificationCloseBtn.isDisplayed() && notificationCloseBtn.isEnabled());
            notificationCloseBtn.click();
            getExtentTest().log(LogStatus.PASS, "Clicking on notification button is done.");

            // Wait for the next page to load
            Thread.sleep(2000);

        } catch (TimeoutException e) {
            // No next page button found, end the loop
            getExtentTest().log(LogStatus.PASS, "Notification is not displayed.");
        } catch (WebDriverException e) {
            // Handle other WebDriver exceptions if necessary
            getExtentTest().log(LogStatus.PASS, "Exception while clicking notification button: \" + e.getMessage()");
        }
    }
    public static void rateAndWriteComment() throws InterruptedException {
        boolean status = true;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try{
            WebElement ratings = wait.until(ExpectedConditions.elementToBeClickable(rating));
            Assert.assertTrue(rating.isDisplayed() && rating.isEnabled());
            rating.click();
            getExtentTest().log(LogStatus.FAIL, "Clicking on rating button is done");
        }
        catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Rating element is not displayed");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Rating element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Rating element");
        }

        try{
            Assert.assertTrue(comment.isDisplayed() && comment.isEnabled());
            comment.sendKeys("Excellent Course");
            getExtentTest().log(LogStatus.FAIL, "Comment added in the comment section");
        }
        catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Comment element is not displayed");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Comment added is done on Comment element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Comment is NOT added in Comment element");
        }
        try{
            // Scroll the element into view
            Assert.assertTrue(updateReview.isDisplayed() && updateReview.isEnabled());
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", updateReview);

            // Wait for a moment to ensure any scrolling has completed
            Thread.sleep(1000);

            // Click using JavaScript to avoid interception
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", updateReview);
            getExtentTest().log(LogStatus.PASS, "Clicking on Update Review  button of notification is done.");
            // Wait for the next page to load
            Thread.sleep(5000);
        }
        catch (Exception exception) {
            getExtentTest().log(LogStatus.FAIL, "Update Review element is not displayed");
            status = false;
        } finally {
            if (status) {
                getExtentTest().log(LogStatus.PASS, "Action is done on Update Review element");
            } else
                getExtentTest().log(LogStatus.FAIL, "Action is NOT done on Update Review element");
        }
    }

    public static List<WebElement> getDownloadCertificateLinks() {
        return downloadCertificateLinks;
    }
    public static void downloadCertificate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        try {
            WebElement course = wait.until(ExpectedConditions.elementToBeClickable(courseLink));
            Assert.assertTrue(course.isDisplayed() && course.isEnabled());
            course.click();
            getExtentTest().log(LogStatus.PASS, "Course link is clicked.");
        } catch (TimeoutException e) {
            // No next page button found, end the loop
            getExtentTest().log(LogStatus.PASS, "Course link is not displayed.");
            return;

        }

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(paid));
            if (element != null) {
                element.click();
            } else {
                throw new RuntimeException("The element 'paid' could not be located on the page.");
            }
            Assert.assertTrue(paid.isDisplayed() && paid.isEnabled());
            getExtentTest().log(LogStatus.PASS, "Paid link is displayed and enabled.");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", paid);
            Thread.sleep(1000);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", paid);
            getExtentTest().log(LogStatus.PASS, "Paid link is clicked.");
        } catch (NoSuchElementException e) {
            getExtentTest().log(LogStatus.PASS, "Paid checkbox is not found.");
            return;
        }

        try {
            // Adding a wait to ensure the page is fully loaded
            List<WebElement> dwnldCertificateLink = wait.until(ExpectedConditions.visibilityOfAllElements(getDownloadCertificateLinks()));

            if (dwnldCertificateLink.isEmpty()) {
                getExtentTest().log(LogStatus.PASS, "No download certificate link found.");
            } else {
                WebElement downloadCertificate = dwnldCertificateLink.get(0); // Change to get(1) if you want the second element
                getExtentTest().log(LogStatus.PASS, "Download certificate link button is displayed and enabled.");
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", downloadCertificate);
                Thread.sleep(5000);
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", downloadCertificate);
                getExtentTest().log(LogStatus.PASS, "Clicked on Download Certificate button.");

                Thread.sleep(15000);
               WebElement certificateImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@id='tutor-pro-certificate-preview']")));
                Assert.assertTrue(certificateImage.isDisplayed() && certificateImage.isEnabled());
                if (certificateImage.isDisplayed()) {
                    getExtentTest().log(LogStatus.PASS, "Certificate is displayed");
                } else {
                    getExtentTest().log(LogStatus.PASS, "Certificate is not displayed.");
                }
            }
        } catch (NoSuchElementException exe) {
            getExtentTest().log(LogStatus.PASS, "Download Certificate link is not found.");
        }
    }
}
