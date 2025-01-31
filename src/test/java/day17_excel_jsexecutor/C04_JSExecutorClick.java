package day17_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutorClick extends TestBase {


    @Test
    void test01() {

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //sell linkine tiklayalim
        WebElement sellLink = driver.findElement(By.xpath("//*[.='Sell']"));
        sellLink.click();//ElementClickInterceptedException

    }

    @Test
    void test02() {

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //sell linkine tiklayalim
        WebElement sellLink = driver.findElement(By.xpath("//*[.='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLink);
    }

    //reusabele method usage
    @Test
    void test03() {

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);

        //sell linkine tiklayalim
        WebElement sellLink = driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sellLink);//test basede bulunan reusable method ile click


    }


}
