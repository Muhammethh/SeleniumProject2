package day06_webelements_xpath;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {

    /*

    / -> Bir alt childı seçer
    // ->  Sayfada ki herhangi bir webelementi secer //div
    @ ->Bir webelementin attributeunu seçmek için kullanılır
    [] -> Index veya koşul belirtmek için kullanılır
    * -> Herhangi bir webelementi seçer (farketmeksizin)


    SYNTAX
    //tagName[@attribute ismi = 'attribute değeri' ]

    // * [ @ * = ' attribute değeri ' ]

    (// tagName [@ attribute ismi = 'attribute değeri' ]) [index]


     */


    @Test
    public void test01() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.navigate().refresh();
        Thread.sleep(3000); //captcha yi manuel olarak açmak için yaptık


        // Arama kutusunda "cıty bike" aratin (arama kutusunu xpath ile locate edin)   //tagName[@attribute ismi = 'attribute değeri' ]
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("city bikes");
        searchBox.submit();

        // Amazon'da gdrüntülenen ilgili sonuçların sayısını vazdirin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuç sayısı = " + resultText.getText());

        // Sadece sonuc sayısını yazdırınız
        String sonuç = resultText.getText().split(" ")[2];
        System.out.println("sonuç = " + sonuç);

        // Sonra karşınıza çıkan ilk sonucun metnine tıklayın.
        driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])[1]")).click();

        // sayfayi kapatınız
        driver.quit();
        Thread.sleep(3000);






    }
}
