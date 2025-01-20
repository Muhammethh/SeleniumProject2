package day08_relativeLocators_dropdown;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {


    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.calculator.net/ adresine gidin
        driver.get("https://www.calculator.net/");

        // '1' düğmesini locate etme
        WebElement one = driver.findElement(By.cssSelector("span[onclick='r(1)']"));

        // Relative Locator kullanarak '0' düğmesini bul ('1'in altında)
        WebElement zero = driver.findElement(RelativeLocator.with(By.tagName("span")).below(one));

        // Relative Locator kullanarak '2' düğmesini bul ('1'in sağında)
        WebElement two = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(one));

        // Relative Locator kullanarak '3' düğmesini bul ('2'nin sağında)
        WebElement three = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(two));

        // Relative Locator kullanarak '4' düğmesini bul ('1'in üstünde)
        WebElement four = driver.findElement(RelativeLocator.with(By.tagName("span")).above(one));

        // Relative Locator kullanarak '5' düğmesini bul ('4'ün sağında)
        WebElement five = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(four));

        // Relative Locator kullanarak '6' düğmesini bul ('5'in sağında)
        WebElement six = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(five));

        // Relative Locator kullanarak '7' düğmesini bul ('4'ün üstünde)
        WebElement seven = driver.findElement(RelativeLocator.with(By.tagName("span")).above(four));

        // Relative Locator kullanarak '8' düğmesini bul ('7'nin sağında, 5'in üzerinde)
        WebElement eight = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(seven).above(five));

        // Relative Locator kullanarak '9' düğmesini bul ('8'in sağında, 6'nın üzerinde)
        WebElement nine = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(eight).above(six));

        // Relative Locator kullanarak sonuç satırını bul ('7, 8, 9'un üzerinde)
        WebElement result = driver.findElement(RelativeLocator.with(By.tagName("div")).above(seven));

        // Her düğmeye tıkla
        one.click();
        Thread.sleep(1000);

        two.click();
        Thread.sleep(1000);

        three.click();
        Thread.sleep(1000);

        four.click();
        Thread.sleep(1000);

        five.click();
        Thread.sleep(1000);

        six.click();
        Thread.sleep(1000);

        seven.click();
        Thread.sleep(1000);

        eight.click();
        Thread.sleep(1000);

        nine.click();
        Thread.sleep(1000);

        zero.click();
        Thread.sleep(1000);


        // Sonucu yazdır
        System.out.println("Sonuç" + result.getText());

        // Tarayıcıyı kapat
        driver.quit();


        /*
        Homework
        Bir tane class oluşturun
        https://www.calculator.net/ adresine gidin
        setup ve teardown methodlarını oluşturun
        4 ayrı test methodu oluşturarak 4 işlemi test edin
        */


    }
}
