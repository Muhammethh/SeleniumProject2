package day05_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Locators {

    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Google sayfasına gidelim
        driver.get("https://www.google.com/");

        // Arama kutusunu "name" attribute e göre bularak "selenium" yazalım
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");

        // Aramaya yapalie
        searchBox.submit();

        // Başlığın selenium içerdiğini test edelim
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().contains("selenium"));

        /*
        Eğer birden fazla webelementi locate etmek istersek findelements methodu kullanırız
        bu method bize elemanları webelement olan bir list return eder
        Bir webelementin üzerinde ki yazıyı alabilmek için getText() methodu kullanırız
         */

        // Sayfada kaç tane link olduğunu yazdıralım
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayısı = " + linkList.size());

        // Sayfadaki linklerin metinleri varsa konsola yazdırallm
        for (WebElement w : linkList){


            if (!w.getText().isEmpty()){

                System.out.println(w.getText());
            }

        }


        // sayfayı kapatalım
        driver.quit();




    }
}
