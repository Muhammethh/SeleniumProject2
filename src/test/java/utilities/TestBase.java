package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {

    protected WebDriver driver;

    //access modifier seçerken mümkün mertebe işimiz gören en dar kapsamlı olanı seçmeliyiz
    //protected sadece diğer packagelerden child olanlar kullanabili diye yazdık yani hangi classlar kullanacak bilelim diye


    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    //Hard wait
    public void waitForSecond(int second){

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    //Select visible Text
    public void selectVisible(WebElement element,String option){

        Select select = new Select(element);
        select.selectByVisibleText(option);

    }

    public void selectIndex(WebElement element,int index){

        Select select = new Select(element);
        select.selectByIndex(index);

    }



}
