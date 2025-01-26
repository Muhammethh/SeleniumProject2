package day13_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C04_RobotClass extends TestBase {


    @Test
    void test01() throws AWTException {


        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.delay(3000);


    }


    @Test
    void test02() {

        //"https://www.ilovepdf.com/compress_pdf" sitesine gidin
        driver.get("https://www.ilovepdf.com/compress_pdf");

        //  dosyayi yukleyin
        driver.findElement(By.id("pickfiles")).click();
        waitForSecond(2);

        String dynamicPath = System.getProperty("user.home") + "\\Downloads\\FileUpload.pdf";
        uploadFilePath(dynamicPath);

        //   dosyanin basariyla yuklendigini test edin
        WebElement uploadedFile = driver.findElement(By.xpath("//span[.='FileUpload.pdf']"));
        Assertions.assertTrue(uploadedFile.isDisplayed());



    }


}