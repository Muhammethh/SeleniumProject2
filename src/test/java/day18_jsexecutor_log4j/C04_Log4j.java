package day18_jsexecutor_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Log4j extends TestBase {

    /*
    project→right click→directory→resources olusturuldu
    →resorces a right click
    →mark diretory as → test resources root
    → recourcesa right click
    → new file → log4j2.xml olusturuldu
    →içine yapılandırma ayarlarını yapıştırıldı.
     daha sonra pom.xml e iki adet dependency ekledik.
     */

    @Test
    void test01() {

        //LogManager.getLogger(C04_Log4j.class); kodu parantez icinde belirtilen class icin
        // bir tane Logger (loglayici) olusturur
        Logger logger = LogManager.getLogger(C04_Log4j.class);

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(2);
        logger.info("Amazon sayfasina gidildi");

        //arama kutusunda selenium aratilir
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        logger.info("Arama kutusunda selenium aratildi");

        logger.info("Sayfa kapatildi");
        driver.quit();
    }
}
