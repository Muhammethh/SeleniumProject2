package day12_actions_faker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsTest extends TestBase {

    @Test
    void test01() {

        //Amazon'a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        waitForSecond(3);


        //Sağ üst bölümde bulunan “Account & Lists” menüsüne git “Account” seçeneğine tıkla
        WebElement element = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform(); //mouseı locate ettiğimiz webelementin üzerine götürdük

        driver.findElement(By.xpath("//span[.='Account']")).click(); //açılan popup tan account linkine tıkladık

        //Açılan sayfanın Title'ının “Your Account” içerdiğini doğrula
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Account";
        Assertions.assertEquals(expectedTitle,actualTitle);


    }




}
