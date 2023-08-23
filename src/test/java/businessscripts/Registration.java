package businessscripts;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration extends BaseTest {

    @Test
    public void RegistrationTest(){
        getDriver().get("https://courses.jkyog.org/");
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().findElement(By.xpath("//span[text() ='Register']")).click();
    }

}
