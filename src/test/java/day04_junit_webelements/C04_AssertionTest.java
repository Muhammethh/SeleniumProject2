package day04_junit_webelements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_AssertionTest {


    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Google web sitesine gidin
        driver.get("https://www.google.com/");

    }

    @Test
    public void pageTitleTest() {


        //Sayfa başlığının Google olduğunu doğrulayın
        String expectedData = "Google";
        String actualData = driver.getTitle();
        Assertions.assertEquals(expectedData, actualData);


    }

    @Test
    public void urlTest() {


        //Sayfa urlnin https://www.google.com/ olduğunu doğrulayın
        String expectedData = "https://www.google.com/";
        String actualData = driver.getCurrentUrl();
        Assertions.assertEquals(expectedData, actualData);

    }

    @AfterEach
    void tearDown() {

        //Sayfayı kapatın
        driver.quit();

    }
}
