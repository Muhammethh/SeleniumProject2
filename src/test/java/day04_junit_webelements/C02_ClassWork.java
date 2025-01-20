package day04_junit_webelements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

import java.time.Duration;

public class C02_ClassWork {
/*
    Interview Sorusu
            Bir classta 4 tane test methodu, 1 tane beforeEach methodu,
            1 tane afterEach methodu varsa classta toplam kaç method çalışmış olur.*/

    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void Test01() {

        driver.get("https://google.com");

    }

    @Test
    public void Test02() {

         driver.get("https://facebook.com");


    }


    @Test
    public void Test03() {

        driver.get("https://techproeducation.com");


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
