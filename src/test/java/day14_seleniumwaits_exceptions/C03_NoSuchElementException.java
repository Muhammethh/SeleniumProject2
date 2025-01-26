package day14_seleniumwaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_NoSuchElementException extends TestBase {


    /*
    NoSuchElementException aliyorsak
    1) Yanlis locate almis olabiliriz, dolayısıyla locate i kontrol etmemiz gerekir
    2) Wait / Syncronization problemi olabilir. implicitly wait de yeterli süre bekledigimizden emin oluruz
        ihtiyaca göre o süreyi artirabiliriz
    3) Locatini almis oldugumuz webelement iframe icindeyse ve iframe e gecis yapmadiysak bu hatayi aliriz
    4) Bazi sayfalarda locate etmek istedigimiz webelement sayfanin altinda olabilir ve driver bunu göremeyebilir
        Dolayisiyla scroll yaparak driver e bu webelementi göstererek bu hatayi handle ederiz
    5) Sayfadaki bir webelemente click yapma sonucunda yeni bir sayfa acildiysa ve driver i bu yeni acilan sayfaya
     gecis yaptirmadan bu sayfadaki bir webelementi locate etmeye calisiyorsak, yine bu hatayi aliriz
     */


    @Test
    void test01() {
        driver.get("https://techproeducation.com");
        WebElement searchBox = driver.findElement(By.id("YANLIS LOCATE"));
        searchBox.sendKeys("Batch254");
    }
}
