package day05_webelements_locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {


    @Test
    public void Test01() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");
        Thread.sleep(5000); //captcha yi manuel olarak aşmak için driverı beklettik

        //Arama kutusunu locate ediniz ve İphone yazdırıp aratınız
        //WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //searchBox.sendKeys("iphone");

        /*Eğer bir arama kutusunu locate edip bir text gönderirisek iki şekilde enter tuşuna basabiliriz
                1:submit() methodu
                2:Keys.ENTER*/

       // searchBox.submit(); //1.Yol

        //2.Yol
       // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);



        //3.Yol name attribute ile bulmak
        driver.findElement(By.name("field-keywords")).sendKeys("iphone",Keys.ENTER);


        //Sayfayı kaptınız
        driver.quit();

    }
}
