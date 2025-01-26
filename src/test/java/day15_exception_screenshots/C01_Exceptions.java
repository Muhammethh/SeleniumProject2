package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Exceptions extends TestBase {

    @Test
    void invalidArgumentException() {
        //InvalidArgumentException -> Bir methoda gecersiz bir arguman gönderilmesi sebebiyle olusur
        driver.get("7https://google.com");
    }

    @Test
    void invalidSelectorException() {
        //invalidSelectorException -> Belirtilen bir locator gecersiz oldugunda ortaya cikar
        driver.get("https://techproeducation.com");
        driver.findElement(By.cssSelector("//*searchHeaderInput"));
    }

    /*
    ==> WebDriverException -> Webdriver ile ilgili kurulum, versiyon uyumsuzluklari yada internet baglanti eksikligi sebepleriyle olusur
    ==> ElementClickInterceptedException -> Bir webelementin baska bir webelement (pop-up, reklam, cookies) tarafindan tiklanmasinin engellenmesi
    ==> ElementNotInteractableException -> Etkilesime acik olmayan bir webelement üzerinde calistigimizda bu excepitonu aliriz
     */



}
