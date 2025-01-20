package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethodsTest {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        
        // TechproEducation sayfasina gidin. https://www.techproeducation.com/
        // Sayfa basligini(title) yazdirin
        // Sayfa basliginin "IT- icerdigini test edin 
        // Sayfa adresini(url) yazdirin
        // Sayfa url'inin "education" ıcerdigıni test edin. 
        // Sayfa handle degerini yazdirın
        // Sayfa HTML kodlarinda "IT Programs" kelimesi gectigini test edin 
        // Sayfayı kapatin.

        driver.get("https://www.techproeducation.com/");

        String TechTitle = driver.getTitle();
        System.out.println("TechTitle = " + TechTitle);
        
        if (TechTitle.contains("IT")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        
        Assertions.assertTrue(TechTitle.contains("IT"));

        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("education")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        
        Assertions.assertTrue(actualURL.contains("education"));

        String windowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);

        if (driver.getPageSource().contains("IT Programs")) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }




}
