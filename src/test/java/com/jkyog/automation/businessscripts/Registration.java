package com.jkyog.automation.businessscripts;

import com.jkyog.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Registration extends BaseTest {

    @Test
    public void RegistrationTest() throws IOException {

        FileInputStream fipConf = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\config.properties");
        Properties prConf = new Properties();
        prConf.load(fipConf);
        String url = prConf.getProperty("prod_url");

        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        FileInputStream fipOr = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\Jkyog\\objectrepository\\or_jkyog.properties");
        Properties prOr = new Properties();
        prOr.load(fipOr);


        String registerIdValue = prOr.getProperty("register_xpath");
        WebElement register = getDriver().findElement(By.xpath(registerIdValue));
        register.click();


        //getDriver().findElement(By.xpath("//span[text() = 'Log In']")).click();
        //getDriver().findElement(By.xpath("//span[text() ='Register']")).click();
    }

}
