package day16_extentreport_webtable_excel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {


    //go to //Amazon
    //Search selenium in the search box
    //verify that the page title contains selenium

    @Test
    void test01() {

        //Amazon Title Test adinda yeni bir test raporu olusturur.
        createExtentReport("Amazon Title Test");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanici Amazon Sayfasina gider");
        waitForSecond(2);
        addScreenShotToReport();

        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");
        addScreenShotOfWebElementToReport(searchBox);
        searchBox.submit();
        extentTest.info("Arama kutusunda selenium yazilarak aratildi");

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assertions.assertTrue(driver.getTitle().contains("selenium"));
        addScreenShotToReport();
        extentTest.pass("Sayfa basliginin selenium icerdigi doğrulandi");
        extentReports.flush();
    }

    /*
    HOMEWORK
    //TechproEducation sayfasina gidin
    //TechproEducation ana sayfada oldugunuzu dogrulayin
    //Ana Sayfada sosyal medya iconlarinin goruntulendigini dogrulayin
    //Extent report ile raporlama yapin
     */

}
