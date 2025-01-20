package day03_managemethods_implicitlywair_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ManageMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        // Sayfanın konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın Konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın Pozisyonu = " + driver.manage().window().getSize());

        // Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        // sımge durumunda 3 saniye bekleyip sayfayı maximize yapin

        Thread.sleep(3000);//bu javadan gelir ve mevcut kodu belirttiğimiz
        // süre kadar durdurur, bizler test uzmanları olarak mümkün olduğunca kullanmaktan kaçınmalıyız
        // çünkü hard waittir ve gereksiz bazı beklemelere neden olur

        driver.manage().window().maximize();

        // Sayfanın konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanın Konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın Pozisyonu = " + driver.manage().window().getSize());

        // Sayfagi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        // Sayfanın konumunu ve boyutlarını fullscreen durumunda yazdirin
        System.out.println("Sayfanın Konumu = " + driver.manage().window().getPosition());
        System.out.println("Sayfanın Pozisyonu = " + driver.manage().window().getSize());

        Thread.sleep(3000);
        // Sayfayı kapatin
        driver.quit();



    }


}
