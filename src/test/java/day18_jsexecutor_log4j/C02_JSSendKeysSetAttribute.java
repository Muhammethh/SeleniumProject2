package day18_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSSendKeysSetAttribute extends TestBase {

    @Test
    void test01() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
        autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute"
        dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */
        js.executeScript("arguments[0].value='selenium'",searchBox);
    }

    //reusable method usage
    @Test
    void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys(searchBox,"selenium");
    }

    /*=================  setAttribute  ==========================   */

    @Test
    void test03() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //arama kutusunun id attribute degerini ismimiz ile degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

            /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
        autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute"
        dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */

        js.executeScript("arguments[0].setAttribute('id','mehmet')",searchBox);

        //değistirmis oldugumuz id ile tekrar locate aldik
        driver.findElement(By.id("mehmet")).sendKeys("SELENIUM");

    }
}
