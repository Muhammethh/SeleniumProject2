package day07_xpath_cssselector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class C04_Cssselector {

    /*
    1) tagName[attributeName='attributeValue']
    2) Eğer id ile css selector almak istersek ==> #idAttributeDeğeri
    3) Eğer class ile css selector almak istersek ==> .classAttributeDeğeri

    Xpath ile Cssselector arasında ki farklar

    1)xpath ile bir webelemnent için birden fazla sonuş verirse index ile bunu teke düşürebiliriz
    fakat cssselector ile index kullanamayız

    2)xpath ile bir webelementi sadece text ile locate edebiliriz
    ama css ile bunu yapamayız

    3)cssselector xpathe göre daha hızlı çalışır*/

    @Test
    public void test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

       //Add Element butonuna basın
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElement.click();
        Thread.sleep(3000);

       //Delete butonu’nun görünür olduğunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        assertTrue(deleteButton.isDisplayed());

       //Delete tuşuna basın
        deleteButton.click();

       //“Add/Remove Elements” yazısının görünür olduğunu test edin
        WebElement addRemoveText = driver.findElement(By.cssSelector("h3"));
        assertTrue(addRemoveText.isDisplayed());

       //Sayfayı kapatınız
        driver.quit();





    }
}
