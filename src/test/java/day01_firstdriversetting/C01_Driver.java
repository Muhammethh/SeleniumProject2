package day01_firstdriversetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Driver {

    public static void main(String[] args) {

        /*ChromeDriver, Seleniumdan gelen komutları alir ve bunlari chrome browserin anlayacagi seklide çevirir
        Bunun icin Selenium a ChromeDriver in projectemizdeki konumunu
        bildirerek Chrome Browserin doğru baslatilmasini saglar*/


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //ilk kısım; key kısmı sadece isim, istenilen şey yazılabilir,
        //ikinci kısım; value kısmı driverın path, yani yolu (path from content root)

        WebDriver driver = new ChromeDriver(); //Boş bir chrome browser açar

        driver.get("https://google.com"); //get(); methodu ile string olarak belirttiğimiz adrese gider

        driver.quit(); //oturumu sonlandırır ve açık olan tüm sayfaları kapatır








    }


}
