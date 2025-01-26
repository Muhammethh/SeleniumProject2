package day13_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {


    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\b10 all test cases, code.docx";
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        /*
        Eger dosya secme webelementinin tagi input ise sendkeys ile dosya yolunu göndererek
         pratik bir sekilde dosya sectirebiliriz
         */

        chooseFile.sendKeys(dosyaYolu);

        waitForSecond(2);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        waitForSecond(2);

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("File Uploaded!", actualText);


    }


}
