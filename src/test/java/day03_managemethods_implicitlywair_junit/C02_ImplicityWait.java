package day03_managemethods_implicitlywair_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImplicityWait {

    public static void main(String[] args) {


        /* Bir web sayfasın gittiğimiz d einterntten kaynaklı yada sayfaya
        çok fazla aynı anda giriş yapılmasında
         server kaynaklı webelementler hemen oluşmayabilir,
         dolayısıyla işlem yapılmak istenen webelement henüz oluşmamış
         ise kodlarımız bu elementi bulamaz ve hata alırız,
         bu yüzden implicitywait kullanarak sayfada ki webelementlerin
         yüklenmesini belirteceğimiz maksimum süre için ayarlarız.
          Bu implicitywait işimizin %80ini çözer kalan %20lik kısım için
          selenium wait konusunda explicit wait konusunu göreceğiz.*/


        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techpro sayfasına gidiniz
        driver.get("https://techproeducation.com");

        // sayfa başlığının TechPro Education icerdiğlni test ediniz
        if (driver.getTitle().contains("TechPro Education")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        // facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        // sayfa url'inin facebook içerdiğini test ediniz
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        // techpro sayfasına geri dönününüz
        driver.navigate().back();

        // Geri döndüğünüzü test ediniz
        //1.YOL
        if (driver.getTitle().contains("TechPro Education")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //2.YOL
        if (driver.getCurrentUrl().equals("https://www.techproeducation.com/")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        // sayfayı kapatınız
        driver.quit();

    }
}
