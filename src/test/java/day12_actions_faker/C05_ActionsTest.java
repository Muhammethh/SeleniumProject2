package day12_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsTest extends TestBase {

    @Test
    void test01() {

        //Google anasayfasına gidelim
        driver.get("https://www.google.com.tr/");
        //arama kutusunda shift tuşuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchbox = driver.findElement(By.id("APjFqb"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchbox, Keys.SHIFT)//arama kutusunda shift tuşuna basılı tutar
                .sendKeys("selenium")//shift tuşuna basılı tutarak selenium yazar
                .keyUp(Keys.SHIFT)//shift tutşundan elini kaldırır
                .sendKeys("java", Keys.ENTER)
                .perform();

    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com.tr/");
        //arama kutusunda shift tuşuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchbox = driver.findElement(By.id("APjFqb"));

        searchbox.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, " - Java", Keys.ENTER);

    }




}
