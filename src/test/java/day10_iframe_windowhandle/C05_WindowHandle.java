package day10_iframe_windowhandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C05_WindowHandle extends TestBase {



    @Test
    void test01() {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // İlk sayfasının Handle değerini alın yazdırın.
        String ilkSayfanınHandleDeğeri = driver.getWindowHandle();

        // İlk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("Opening a new window",actualText);

        // İlk sayfa Title’ının “The Internet” olduğunu test edin.
        Assertions.assertEquals("The Internet",driver.getTitle());

        // “Click Here” butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Here")).click();


        /*
        Handle değeri ilk sayfaya eşit olmayana geçiş yap diyerek kontorlümüz dışında açılan sayfaya driverı geçirdik
        ve daha sonra da geçtiğimiz sayfanın handle değerini de aldık
         */

        // İkinci sayfa Title’ının “New Window” olduğunu test edin.
        Set<String> windowHandles = driver.getWindowHandles();

        for (String w : windowHandles){

            if (!ilkSayfanınHandleDeğeri.equals(w)){

                driver.switchTo().window(w);

            }

        }
        String ikinciSayfanınwindowHandle = driver.getWindowHandle();
        Assertions.assertEquals("New Window",driver.getTitle());

        // İlk sayfaya dönün ve Title’ının “The Internet” olduğunu test edin.
        driver.switchTo().window(ilkSayfanınHandleDeğeri);
        Assertions.assertEquals("The Internet",driver.getTitle());

        // İkinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfanınwindowHandle);

        // İlk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfanınHandleDeğeri);

    }


    //Reusable method ile window handle
    @Test
    void test02() {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // İlk sayfasının Handle değerini alın yazdırın.


        // İlk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("Opening a new window",actualText);

        // İlk sayfa Title’ının “The Internet” olduğunu test edin.
        Assertions.assertEquals("The Internet",driver.getTitle());

        // “Click Here” butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Here")).click();


        /*
        Handle değeri ilk sayfaya eşit olmayana geçiş yap diyerek kontorlümüz dışında açılan sayfaya driverı geçirdik
        ve daha sonra da geçtiğimiz sayfanın handle değerini de aldık
         */

        waitForSecond(2);
        // İkinci sayfa Title’ının “New Window” olduğunu test edin.
        switchToWindow(1);
        waitForSecond(2);
        Assertions.assertEquals("New Window",driver.getTitle());

        // İlk sayfaya dönün ve Title’ının “The Internet” olduğunu test edin.
        switchToWindow(0);
        waitForSecond(2);
        Assertions.assertEquals("The Internet",driver.getTitle());

        // İkinci sayfaya tekrar geçin.
        switchToWindow(1);
        waitForSecond(2);

        // İlk sayfaya tekrar dönün.
        switchToWindow(0);
        waitForSecond(2);

    }

}
