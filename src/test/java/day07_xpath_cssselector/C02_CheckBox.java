package day07_xpath_cssselector;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {


    @Test
    public void test01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // Verilen web sayfasina gidin. https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes ");

        // Checkbox1 ye checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));


        // Checkbox1 secili degilse onay kutusunu tlklayin
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

        // Checkbox2 secill degilse onay kutusunu tiklayin
        if (!checkbox2.isSelected()){
            checkbox1.click();
        }

        // Sayfayi kapatin
        driver.quit();




    }
}
