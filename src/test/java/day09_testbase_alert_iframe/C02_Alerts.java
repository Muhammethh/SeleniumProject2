package day09_testbase_alert_iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alerts extends TestBase {


    /*
        Eğer bir sayfadaki bir butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye inspect
        locate alamıyorsak bu bir JS Alert tür.

        ==> JS Alert'ü handle edebilmek için driver'imizi o pencereye geçirmemiz gerekir
        ==> Bunun için driver objemiz üzerinden switchTo().alert() diyerek geçiş yapabiliriz

        ==> accept() -> onaylar
        ==> dismiss() -> cancel'a basar (iptal eder)
*/


    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts


    @Test
    void acceptAlert() {
        // Bir metod oluşturun: acceptAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // birinci butona tıklayın,
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();

        // result mesajının "You successfully clicked an alert" olduğunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assertions.assertEquals(expectedResult,actualResult);


    }

    @Test
    void dismissAlert() {
        // Bir metod oluşturun: dismissAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // ikinci butona tıklayın,
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();

        // result mesajının "successfully" içermediğini test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String unexpectedResult = "successfully";
        Assertions.assertFalse(actualResult.contains(unexpectedResult));
    }

    @Test
    void sendKeysAlert() {
        // Bir metod oluşturun: sendKeysAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // üçüncü butona tıklayın,
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        // uyarıdaki metin kutusuna isminizi yazın,
        driver.switchTo().alert().sendKeys("Muhammet");

        // OK butonuna tıklayın
        driver.switchTo().alert().accept();


        // result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "Muhammet";

        Assertions.assertTrue(actualResult.contains(expectedResult));
    }


}
