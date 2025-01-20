package day10_iframe_windowhandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandle extends TestBase {

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
        String youtubewindowHandle = driver.getWindowHandle();

        // Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedınindowHandle = driver.getWindowHandle();

        // techproeducation sayfasına geçiniz,
        driver.switchTo().window(TechProwindowHandle);

        // youtube sayfasına geçiniz,
        driver.switchTo().window(youtubewindowHandle);

        // linkedin sayfasına geçiniz
        driver.switchTo().window(linkedınindowHandle);

    }

    @Test
    public void test02() {

        // Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String TechProwindowHandle = driver.getWindowHandle();

        // Başlığın "TechPro Education" içerdiğini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        // Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubewindowHandle = driver.getWindowHandle();

        // Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedınindowHandle = driver.getWindowHandle();

        // techproeducation sayfasına geçiniz,
        driver.switchTo().window(TechProwindowHandle);

        // youtube sayfasına geçiniz,
        driver.switchTo().window(youtubewindowHandle);

        // linkedin sayfasına geçiniz
        driver.switchTo().window(linkedınindowHandle);

    }




}
