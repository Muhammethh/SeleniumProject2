package day07_xpath_cssselector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.validation.ValidatorHandler;
import java.time.Duration;

public class C01_XpathClassWork {

    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        /*Options;
        1.yol: //button[@onclick='addElement()']
        2.yol: //button[text()='Add Element']
        3.yol: //button[.='Add Element']
        4.yol: //button[contains(text(),'Add')]
        */


        // Add Element butonuna basin
        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();
        Thread.sleep(3000);

        // Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Del')]"));
        Assertions.assertTrue(deleteButton.isDisplayed());

        // Delete tusuna basin
        deleteButton.click();

        // "Add/Remove Etements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveText = driver.findElement(By.xpath("//h3"));
        Assertions.assertTrue(addRemoveText.isDisplayed());
        Thread.sleep(3000);

        // sayfayi kapatin
        driver.quit();


    }
}
