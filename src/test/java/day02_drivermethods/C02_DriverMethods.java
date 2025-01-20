package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //Google sayfasına gidelim
        driver.get("https://google.com");

        //Sayfa başlığını konsola yazdıralim
        String actualGoogleTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualGoogleTitle);

        //Sayfanın urlini konsola yazdıralım
        String actualGoogleUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualGoogleUrl);

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfa başlığını konsola yazdıralım
        String actualTechTitle = driver.getTitle();
        System.out.println("actualTechUrl = " + actualTechTitle);

        //Sayfanın urlini konsola yazdıralım
        String actualTechUrl = driver.getCurrentUrl();
        System.out.println("actualTechUrl = " + actualTechUrl);

    }


}
