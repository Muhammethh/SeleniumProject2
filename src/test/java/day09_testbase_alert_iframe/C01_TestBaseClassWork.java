package day09_testbase_alert_iframe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_TestBaseClassWork extends TestBase {

    @Test
    public void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

      /*  1.Method:
        a. Yil,ay,gun dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullanarak 3 farkli sekilde seçim yapiniz*/

        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        //yıl ay gün dropdaown menülerinden reusablemethodlar ile seçim yapalım
        waitForSecond(1);
        selectIndex(year,1);
        waitForSecond(1);
        selectIndex(month,2);
        waitForSecond(1);
        selectIndex(day,3);

        selectVisible(year,"1999");
        waitForSecond(1);
        selectVisible(month,"August");
        waitForSecond(1);
        selectVisible(day,"19");
        waitForSecond(1);



    }


}
