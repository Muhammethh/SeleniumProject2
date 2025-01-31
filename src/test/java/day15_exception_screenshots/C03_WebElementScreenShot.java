package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_WebElementScreenShot extends TestBase {

     /*
    Eger sadece bir webelementin ekran görüntüsünü almak istersek o webelementin locate ini alip getScreenShotAs() methodu ile alabiliriz
    TakeScreenShot ile driver type casting yapmaya gerek yok, çünkü selenium 4 itibari ile webelement methodlari icinde getScreenShotAs() methodu mevcut
     */

    //go to the Amazon page
    //take the screenshot
    //write laptop in the search box
    //get the image of the searchbox webelement

    @Test
    void test01() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //ekran resmini alalım
        screenShot();

        //Arama kutusunda laptop yazalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");

        //arama kutusu webelementinin resmini alalım
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu="src/test/java/screenShots/webElementSS"+date+".png";
        Files.write(Paths.get(dosyaYolu), searchBox.getScreenshotAs(OutputType.BYTES));


    }


    //reusable method kullanimi
    @Test
    void test02() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //ekran resmini alalım
        screenShot();

        //Arama kutusunda laptop yazalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");

        //arama kutusu webelementinin resmini alalım
        waitForSecond(1);
        screenShotOfWebElement(searchBox);

    }

    /*
    HOMEWORK
    //Techproeducation sayfasına gidelim
    //Ana sayfanın başarıyla yüklendiğini doğrula.
    //Sayfanın ekran görüntüsünü alin
    //Sayfanın basinda görüntülenen telefon numarasinin +1 585 304 29 59 oldugunu dogrulayin
    //goruntulenen telefon numarasinin ekran goruntusunu alin
     */



}
