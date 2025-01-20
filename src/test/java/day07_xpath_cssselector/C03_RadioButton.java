package day07_xpath_cssselector;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    @Test
    public void test01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // "Create an Account" buttonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // "radio buttons" elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));

        // Cinsiyet butonundan size uygun olani secin
        male.click();




    }
}
