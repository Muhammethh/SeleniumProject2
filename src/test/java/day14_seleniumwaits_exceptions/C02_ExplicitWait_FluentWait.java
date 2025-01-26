package day14_seleniumwaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_FluentWait extends TestBase {

    @Test
    void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et

        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));

        wait.withTimeout(Duration.ofSeconds(20))//max bekletme süresini ayarladik
                .pollingEvery(Duration.ofMillis(200))//belirttigimiz araliklar ile kosulu kontrol ediyoruz
                .withMessage("Webelementi ve süreyi kontrol et")//Eger belirtilen max sure icinde kosul saglanmaz ise
                // burada yazmis oldugumuz hata mesaji konsolda TimeOutException ile birlikte görünecek
                .until(ExpectedConditions.visibilityOf(helloWorld));//Webelementin görünür olup olmadigini kontrol ettik

        Assertions.assertEquals("Hello World!",helloWorld.getText());

    }


}
