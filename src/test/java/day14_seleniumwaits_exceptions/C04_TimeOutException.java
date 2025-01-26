package day14_seleniumwaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_TimeOutException extends TestBase {


     /*
    TimeOutException ==> Explicit wait kullanildiginda ve webelement bulunamadiginda alinan bir hatadir
        İmplicitly wait te süre yeterli olmazsa NoSuchElementException alirsiniz
        1) Explicit Wait te kullandigimiz max. sureyi kontrol etmeliyiz
        2) Explicit Wait te aldiğimiz locate i kontrol etmeliyiz
        3) Explicit Wait te kullandigimiz methodu kontrol etmeliyiz
        4) Explicit Wait ile aldigimiz locate iframe icinde kalabilir

     */

    @Test
    void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et
        //waitForSecond(5); => hardwait kullanmaktan mumkun oldugunca kacinmaliyiz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assertions.assertEquals("Hello World!",helloWorld.getText());

    }

}
