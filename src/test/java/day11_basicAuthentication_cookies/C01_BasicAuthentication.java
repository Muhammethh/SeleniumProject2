package day11_basicAuthentication_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {



    @Test
    void test01() {

        // Aşağıdaki bilgileri kullanarak authentication yapınız:
        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


        // Congratulations! You must have the proper credentials. yazısının çıktığını doğrulayın
        String actualText = driver.findElement(By.xpath("//p")).getText();
        Assertions.assertEquals("Congratulations! You must have the proper credentials.",actualText);

        // Elemental Selenium linkine tıklayınız
        driver.findElement(By.partialLinkText("Elemental Selenium")).click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());


        // Başlığın Elemental Selenium içerdiğini test edelim
        Assertions.assertTrue(driver.getTitle().contains("Elemental Selenium"));

    }



}
