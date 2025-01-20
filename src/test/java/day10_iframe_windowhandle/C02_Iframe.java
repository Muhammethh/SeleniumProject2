package day10_iframe_windowhandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Iframe extends TestBase {



    @Test
    void test01() {
        // https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        // Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertTrue(actualText.contains("Editor"));

        // Textboxun içindeki metnin "Your content goes here." olduğunu test edin

        driver.switchTo().frame("mce_0_ifr");  //->id attribute valuesu ile geçiş yaptık
        String actualTextBox = driver.findElement(By.xpath("//p[.='Your content goes here.']")).getText();
        String expectedTextBox = "Your content goes here.";
        Assertions.assertEquals(expectedTextBox,actualTextBox);

        // Sayfadaki "Elemental Selenium" yazısının olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        driver.navigate().refresh(); // eğer iframe içinde form vs doldurulmuyorsa kullanılabilir
        String actualElementalSeleniumText = driver.findElement(By.partialLinkText("Elemental Selenium")).getText();
        Assertions.assertEquals("Elemental Selenium",actualElementalSeleniumText);

    }

    // homework
    // https://html.com/tags/iframe sayfasına gidiniz
    // sayfada bulunan youtube videosunu başlatınız


}
