package day14_seleniumwaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_StaleElementReferenceException extends TestBase {


    /*
    StaleElementReferenceException
    => Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde
    sakladiktan sonra o sayfada herhangi bir yenile islemi (navigate.refresh(),back().forward())
    yapildiginda locate ini aldigimiz webelementi tekrar kullanmak istersek bu exceptionu aliriz

    Bu hatayi nasil handle ederiz?
    sayfada herhangi bir yenile islemi (navigate.refresh(),back().forward()) yapildiktan sonra
    locate i tekrar almaliyiz
     */
    @Test
    void test01() {
        driver.get("https://techproeducation.com");
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));

        driver.navigate().refresh();
        searchBox = driver.findElement(By.id("searchHeaderInput"));
        searchBox.sendKeys("CAYLAR ARTIK TAZE :) ");
    }


}
