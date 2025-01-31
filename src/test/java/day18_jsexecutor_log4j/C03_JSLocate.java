package day18_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSLocate extends TestBase {

    @Test
    void test01() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //js executor ile search box i locate edelim
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox')");
        searchBox.sendKeys("selenium");
    }

    @Test
    void test02() {

        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Events yazisini BATCH 254 ile degistirelim
        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent='BATCH 254'",eventsText);

        //EventText webelementinin etrafina 5 pixel kalinliginda kırmızı bir cizgi cerceve ekleyelim
        js.executeScript("arguments[0].style.border = '5px solid red'",eventsText);

        //EventText webelementinin arka plan rengini yesil olarak ayarladik
        js.executeScript("arguments[0].style.backgroundColor = 'green'",eventsText);

        //EventText webelementinin metin rengini beyaz yaptik
        js.executeScript("arguments[0].style.color = 'white'",eventsText);

    }
}
