package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_Driver {

    public static void main(String[] args) {

       /* WebDrıverManager sayesinde ıstedıgımiz browser icin setup yaparak otomasyonda kullanabilrız
        Bu sayede browser a gore gereklı olan driver i bilgısayarımıza indirmek, yapılandirmak.. zorunda kalmayız.*/


        //Chrome için...
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://google.com");
        chromeDriver.quit();

        //Edge tarayıcısı için...
        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://google.com");
        edgeDriver.quit();

        //Firefox tarayıcısı
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://google.com");
        firefoxDriver.quit();


    }



}
