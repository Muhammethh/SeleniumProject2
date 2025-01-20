package day10_iframe_windowhandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_iframe extends TestBase {

    /*
    Bir webelementi locate ettikten sonra NoSuchElementException alıyorsa
    öncelikle locatei kontrol ederiz buna rağmen aynı hatayı alıyorsak
    locate etmek istediğimiz webelement iframe içinde olabilir.
    Dolayısıyla iframe içinde ki bir webelement ile driveri etkileşime
    geçirebilmek için driverı iframe geçiş yaptırmamız gerekir
    1)   driver.switchTo().frame(iframe indexi --->index 0dan başlar);
    2)   driver.switchTo().frame(<iframe id="abc", name = "abc"> id/name attribute değeri);
    3)   driver.switchTo().frame(iframi webelement olarak locate ederek);
    4)  Eğer iç içe iframelere geçiş yaptık ve ana sayfaya geçiş yapmak istersek driver.switchTo().frame().defaultContent()
    ile geçiş yapabiliriz
    5)  bir üst iframe içinse driver.switchTo().frame().parentFrame() kullanırız


     */


    @Test
    void test01() {
        // https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        // Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazısının olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assertions.assertTrue(actualText.contains("black border"));

        // Ayrıca 'Applications lists' yazısının sayfada olduğunu test edin.
        driver.switchTo().frame(0);
        String applicationListText = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        Assertions.assertEquals("Applications lists", applicationListText);

        // Sayfada iframe yazısının olduğunu test edin.
        driver.switchTo().defaultContent();
        String iframeText = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("iframe", iframeText);
    }


}
