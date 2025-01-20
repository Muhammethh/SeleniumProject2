package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_NavigateMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // techproeducatıon ana sayfasına gidelim . https://www.techproeducation.com/
        driver.navigate().to(" https://www.techproeducation.com/"); // get method gibi verilen urle gider

        // Amazon sayfasına gidelim. https://www.amazon.com
        driver.navigate().to("https://www.amazon.com");


        // Tekrar techproeducation sayfasina donelim
        driver.navigate().back();

        // Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        // Sayfayı Refresh(yenile) yapalım
        driver.navigate().refresh();

        // Tum sayfaları kapatalim
        driver.quit();

    }
}
