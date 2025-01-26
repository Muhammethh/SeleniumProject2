package day13_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {


    //Go to https://testcenter.techproeducation.com/index.php?page=file-download
    //download b10 all test cases file
    //Test whether the file has been downloaded successfully


    @Test
    void test01() {

        /*
        Files.delete(Paths.get(dosyaYolu)); methodu belirtilen dosya varsa siler, eger dosya silinemez ise exception firlatir
         */

        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.err.println("DOSYA SILINEMEDI !!!");
        }
        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases, code.docx")).click();

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //"C:\Users\mua\Downloads\b10 all test cases, code.docx"
        waitForSecond(2);
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}
