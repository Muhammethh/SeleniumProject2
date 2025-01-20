package day08_relativeLocators_dropdown;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropdownMenu {

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
    public void test02() {

        // 2. Method:
        // a. Tüm eyalet isimlerini yazdiralim

        WebElement states = driver.findElement(By.cssSelector("#state"));
        Select options = new Select(states);
        List<WebElement> allStates = options.getOptions();

        for (WebElement eachState : allStates) {

            System.out.println(eachState.getText());

        }
        System.out.println("******************************************");
        //ikinci yol
        allStates.forEach(t -> System.out.println(t.getText()));


    }


    @Test
    public void test02a() {

        List<WebElement> allStates = driver.findElements(By.xpath("//select[@id='state']/option"));
        allStates.forEach(t -> System.out.println(t.getText()));

    }

    @Test
    public void test01Trick() {

      /*  1.Method:
        a. Yil,ay,gun dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullanarak 3 farkli sekilde seçim yapiniz*/

        driver.findElement(By.id("year")).sendKeys("2020");
        driver.findElement(By.id("month")).sendKeys("May");
        driver.findElement(By.id("day")).sendKeys("19");



        /*

        Çoğu zaman bu dropdown webelementine sendKeys metohodu ile alt başlıklardan herhang, bir seçeneği gönderebiliriz

         */


    }


    @Test
    public void test03() {

       // 3. Method:
       // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement states = driver.findElement(By.cssSelector("#state"));
        Select options = new Select(states);

        String actualOption = options.getFirstSelectedOption().getText();
        String expectedOption = "Select a State";
        Assertions.assertEquals(expectedOption,actualOption);


    }
}
