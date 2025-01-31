package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {

     /*
    Bir sayfanin ekran görüntüsünü almak istersek;
    1- Almak istedigimiz ekran görüntüsünü kaydetmek icin bir dosya yolu aliriz
    2- TakeScreenShot tipinde object declare edip driveri bu objecte assign edeceğiz
    3- Files classindan write() methodu kullanarak, almıs oldugumuz ekran görüntüsünü yine almıs olduğumuz dosya yoluna kaydedeceğzi
     */

    @Test
    public void test01() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın ekran görüntüsünü alalim
        String dosyaYolu="src/test/java/screenShots/techpro.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));


    }


    @Test
    void test02() {
        //google sayfasına gidiniz
        driver.get("https://google.com");

        //Sayfanın resmini alınız
        String dosyaYolu="src/test/java/screenShots/google.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //DYNAMIC PATH
    @Test
    void test03() {
        //google sayfasına gidiniz
        driver.get("https://google.com");

        //Sayfanın resmini alınız
        //LocalDateTime.now() ==> bize anlik zamani verir
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu="src/test/java/screenShots/google"+date+".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //reusable method ile screen shot
    @Test
    void test04() {
        //google sayfasına gidiniz
        driver.get("https://google.com");

        //ekran görüntüsü alalim
        screenShot();

    }


}
