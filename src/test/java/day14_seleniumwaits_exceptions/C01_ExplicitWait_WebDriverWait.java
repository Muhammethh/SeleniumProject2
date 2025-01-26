package day14_seleniumwaits_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait_WebDriverWait extends TestBase {


      /*
    Selenium Waits
    1) Implicitly Wait
        => Bir websayfasina gittikten sonra sayfadaki tum webelementlerin driver ile etkilesime gecebilmesi
        icin belirtmis oldugumuz maximum sure kadar driveri bekletiriz.

    2) Explicit Wait
         => Bir kosulun gerceklesmesi farkli sürelerde meydana gelebilir, böyle bir durumda Thread.sleep kullanmamiz
        profosyonel bir yaklasim olmaz, Bunun yerine Explicit ile bekleriz

        a) WebDriverWait
        => Bir websayfasi yuklendikten sonra bir webelement ile ilgili specific bir kosul icin
        max. belirtmis oldugumuz süre kadar bekletiriz, Bu sure default olarak  yarim saniyelik araliklar ile olur

        b) FluentWait
       => Bir websayfasi yuklendikten sonra bir webelement ile ilgili specific bir kosul icin
        etkilesime gecebilmek icin max. belirtmis oldugumuz süre kadar bekletiriz,
        Bu sure belirteceğimiz araliklar ile olur

     */


    @Test
    void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assertions.assertTrue(helloWorld.isDisplayed());


    }


    @Test
    void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! Yazının sitede oldugunu test et

         /*
        Locatini aldigimiz webelement görünür olana kadar bekle dedik ve gorunur olduktan sonrada o webelementi
        bize ver dedik
         */

        WebElement helloWorld = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        Assertions.assertEquals("Hello World!",helloWorld.getText());
    }


}
