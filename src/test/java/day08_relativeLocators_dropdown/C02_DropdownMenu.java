package day08_relativeLocators_dropdown;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropdownMenu {


    /*
    Dropdown menüyü automate etmek için;

    1) Dropdown menüyü locate edeceğiz
    2)Select objecti oluşturulu
    3)Select objesi üzerinden çeşitli metotlar sayesinde dropdown seçeneklerine erişim sağları


    SYNTAX
    Select select = new Select(WebElement Dropdown);

    Select objecti üzerinden ddm handle edebileceğimiz 3 tane method var

    a) selectByVisibleText() -> DDMde ki elementi görünür metin ile seçer
    b) selectByIndex -> DDMde ki elementi index ile seçer, index sıfırdan başlar
    c) selectByValue -> DDMde ki elementi value attribute değeri ile seçer (option tagi ile başlar)
    d) getOptions() -> Locate ettiğimiz DD menüde ki tüm seçenekleri liste koyarak bize verir
    e) getFirstSelectedOption() -> DD menüde ki seçili olan seçeneği bize verir

     */





   /*Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
       -3 farkli test methodu olusturalim
        1.Method:
             a. Yil,ay,gun dropdown menu'leri locate ediniz
             b. Select objesi olustur
             c. Select object i kullaarak 3 farkli sekilde sedan; yapiniz
        2. Method:
             a. Tüm eyalet isimlerini yazdiralim
   3. Method:
             a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim*/


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {

      /*  1.Method:
        a. Yil,ay,gun dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullanarak 3 farkli sekilde seçim yapiniz*/

        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        selectYear.selectByIndex(0); //index 0'dan başlar,0 yazarsak ilk element seçilir, 3 yazarsak 4. element seçilir
        selectMonth.selectByValue("3");// <option value="3">April</option>   ||value attribute değerine göre seçim yapar
        selectDay.selectByVisibleText("13"); //ekranda görünür metne göre seçim yapar



    }



}
