package day12_actions_faker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {

    @Test
    void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        Actions actions = new Actions(driver);


        //Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        driver.switchTo().frame(0);


        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).perform();

    }


    @Test
    void test02() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        Actions actions = new Actions(driver);


        //Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        driver.switchTo().frame(0);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.clickAndHold(draggable)//drag webelementine tıklar ve basılı tutar
                .moveToElement(droppable)//drag webelementiti tutup drop webelementinin üzerine götürür
                .release()//basılı tutulan webelementi serbst bırakır
                .perform();

    }

    @Test
    void test03() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        Actions actions = new Actions(driver);


        //Drag me to my target webelementini Drop here webelementi üzerine bırakalım
        driver.switchTo().frame(0);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.clickAndHold(draggable).moveByOffset(139,49)
                .release()
                .perform();
    }

    //HOMEWORK drag elementinin drop elementi üzerine bırakıldığını test edin


}
