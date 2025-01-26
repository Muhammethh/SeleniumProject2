package day12_actions_faker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_ActionsTest extends TestBase {


    @Test
    void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sağ tıklayın
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        //Kullnadığımız actions methodlarını işleme alması için perform() methodunu kullanmalıyız

        //Alert'te çıkan yazının "You selected a context menu" olduğunu test edin
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assertions.assertEquals(expectedText,actualText,"Actual Data ile Expected Data uyumlu değil");

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();

    }
}
