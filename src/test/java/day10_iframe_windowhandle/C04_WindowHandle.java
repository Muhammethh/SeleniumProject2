package day10_iframe_windowhandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_WindowHandle extends TestBase {



    @Test
    public void test01() {

        // Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String TechProwindowHandle = driver.getWindowHandle();

        // Başlığın "TechPro Education" içerdiğini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        // Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");


        // Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");


        /*
        Açılmış olan tüm pencerelerin window handle değerlerini getWindowHandles() methodu ile aldık,
        driver.getWindowHandles() methodu set return eder
        setlerde index kullanarak istediğimiz bir elemanı seçmek mümkün değildi
        Bu nedenle seri kullanarak bir tane list oluşturduk çünkü listlerde get() methodu sayesinde indez kullanarak
        istediğimiz pencereye rahatlıkla geçiş yapabileceğiz
         */

        List<String> listWindowHandle = new ArrayList<>(driver.getWindowHandles());



        // techproeducation sayfasına geçiniz,
       driver.switchTo().window(listWindowHandle.get(0));

        // youtube sayfasına geçiniz,
        driver.switchTo().window(listWindowHandle.get(1));

        // linkedin sayfasına geçiniz
        driver.switchTo().window(listWindowHandle.get(2));

    }

    @Test
    public void test02() {

        // Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String TechProwindowHandle = driver.getWindowHandle();

        // Başlığın "TechPro Education" içerdiğini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        // Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");


        // Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");





        // techproeducation sayfasına geçiniz,
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        // youtube sayfasına geçiniz,
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        // linkedin sayfasına geçiniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

    }


}
