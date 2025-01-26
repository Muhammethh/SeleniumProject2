package day12_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C03_ActionsTest extends TestBase {


    /*
Eğer bir webelement pencerede görünür değilse driver bu webelementi bulamayabilir,
daha sağlıklı bir test için scroll yaparak bu webelementi görünür yapmamız gerekir
*/

    @Test
    void test01() {

        //Techpro education sayfasına gidelim
        driver.get("https://techproeducation.com");

        //sayfayı istediğimiz kadar aşağıya doğru scroll yapalım
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(3);
        action.sendKeys(Keys.PAGE_UP).perform();
        waitForSecond(3);

        //sayfayı istediğimiz kadar yukarıya doğru scroll yapalım
        for (int i = 0; i < 5; i++) {

            action.sendKeys(Keys.PAGE_DOWN).perform();
            waitForSecond(1);
            
        }

        for (int i = 0; i < 5; i++) {

            action.sendKeys(Keys.PAGE_UP).perform();
            waitForSecond(1);

        }
        
    }

    @Test
    public void test02() {

        //Techpro education sayfasına gidelim
        driver.get("https://techproeducation.com");

        Actions action = new Actions(driver);

        //Sayfanın en sonuna gidin
        action.sendKeys(Keys.END).perform();
        waitForSecond(2);

        //Sayfanın en başına gidin
        action.sendKeys(Keys.HOME).perform();
        waitForSecond(2);

    }

    @Test
    public void test03() {

        //Techpro education sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Events yazısına kadar scroll yapalım
        Actions actions = new Actions(driver);

        WebElement eventsText = driver.findElement(By.xpath("//h2[.='Events']"));
        actions.scrollToElement(eventsText).perform();


    }
}
