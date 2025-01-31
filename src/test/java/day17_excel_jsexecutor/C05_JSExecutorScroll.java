package day17_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_JSExecutorScroll extends TestBase {



    //specific bir webelemente js executor ile scroll
    @Test
    void test01() {
        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        //Challenges a kadar scroll yapiniz
        WebElement challenges = driver.findElement(By.xpath("//h2[.='Challenges']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",challenges);
    }


}
