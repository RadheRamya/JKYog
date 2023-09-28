package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Login extends BaseTest {
    @Test
    public void loginTest() throws IOException {
        FileInputStream fipConf = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\config.properties");
        Properties prConf = new Properties();
        prConf.load(fipConf);
        String url = prConf.getProperty("prod_url");

        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        FileInputStream fipOr = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\Jkyog\\objectrepository\\or_jkyog.properties");
        Properties prOr = new Properties();
        prOr.load(fipOr);

        String loginValue = prOr.getProperty("login_xpath");
        WebElement login = getDriver().findElement(By.xpath(loginValue));
        login.click();

        String unIdValue = prOr.getProperty("un_id");
        WebElement userName = getDriver().findElement(By.xpath(unIdValue));
        userName.sendKeys("radheykrishna");

        String pwdIdValue = prOr.getProperty("pwd_id");
        WebElement password = getDriver().findElement(By.xpath(pwdIdValue));
        password.sendKeys("Radhey@13");

        String loginIdValue = prOr.getProperty("login_id");
        WebElement loginButton = getDriver().findElement(By.xpath(loginIdValue));
        loginButton.click();

    }
}