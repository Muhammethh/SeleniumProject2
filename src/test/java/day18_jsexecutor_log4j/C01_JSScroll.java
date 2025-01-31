package day18_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C01_JSScroll extends TestBase {

    @Test
    void test01() {

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Sayfanin toplam yuksekligini dynamic olarak aldik ve y koordinati olarak belirttik
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        waitForSecond(2);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }

    //reusable method usage
    @Test
    void test02() {

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //sayfanın en altına scroll yapalım
        jsScrollEnd();
        waitForSecond(2);

        //sayfanin en üstüne scroll yapalim
        jsScrollHome();

    }



}
