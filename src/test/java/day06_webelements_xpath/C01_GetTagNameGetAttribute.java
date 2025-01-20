package day06_webelements_xpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {


    @Test
    public void test01() {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com/");

        // arama kutusunun tag name'inin input olduğunu test edelım
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));
        String expectedTagName = "input";
        String actualTagName = searchBox.getTagName();
        Assertions.assertEquals(expectedTagName, actualTagName);

        // arama kutusunun class attribütunun değerinin form-input olduğunu test ediniz
        String expectedClassAttributeValue = "form-input";
        String actualClassAttributeValue = searchBox.getAttribute("class");
        Assertions.assertEquals(expectedClassAttributeValue, actualClassAttributeValue);


        // sayfayı kapatınız
        driver.quit();


    }
}
