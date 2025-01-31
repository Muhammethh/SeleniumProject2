package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {

    protected WebDriver driver;

    //access modifier seçerken mümkün mertebe işimiz gören en dar kapsamlı olanı seçmeliyiz
    //protected sadece diğer packagelerden child olanlar kullanabili diye yazdık yani hangi classlar kullanacak bilelim diye


    /*
    ExtentReport kullanabilmek icin 3 classa ihtiyacimiz var
     */

    protected ExtentReports extentReports; //raporlamayi baslatir
    protected ExtentHtmlReporter extentHtmlReporter; //html formatinda rapor olusturur
    protected ExtentTest extentTest;//test adimlarina bilgi eklememizi saglar


    //Extent Report
    public void createExtentReport(String testName) {
        //ExtentReports classindan bir object olusturarak raporlamayi baslatiriz,
        // bu objeyi raporlari olusturmak ve yonetmek icin kullanacağız
        extentReports = new ExtentReports();

        //öncelikle olusturmak istedigimz html reportu projemizde nerede saklamak istiyorsak
        // bu path i kullanakak bir tane html rapor olusturmaliyiz
        // bunun icin ExtentHtmlReporter classindan obje olusturmaliyiz
        // pathin sonunda .html seklinde yazmayi unutmamaliyiz
        String date = DateTimeFormatter.ofPattern("HHmmssddMMyy").format(LocalDateTime.now());
        String path = "target/extentReport/" + date + "htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //extentHtmlReporter objesini extentReports objesine ekler
        // böylece extentReports objesi extentHtmlReporter raporlayicisi vasitasiyla HTML raporlarini olusturur
        extentReports.attachReporter(extentHtmlReporter);

        //Bu html raporunda görmek isteyebileceğimiz bilgileri asagidaki gibi ekleyebiliriz
        extentReports.setSystemInfo("Test Automation Engineer", "Ali Can");
        extentReports.setSystemInfo("Enviornment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");


        //Html dökümanimizin bilgilerini ayarladik, rapor ismi ve döküman ismi ekleyebiliriz
        extentHtmlReporter.config().setDocumentTitle("Batch 254 Test Report");
        extentHtmlReporter.config().setReportName("My Extent Report");
        extentTest = extentReports.createTest(testName, "Test Steps");
    }


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
    public void waitForSecond(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    //Select visible Text
    public void selectVisible(WebElement element, String option) {

        Select select = new Select(element);
        select.selectByVisibleText(option);

    }

    public void selectIndex(WebElement element, int index) {

        Select select = new Select(element);
        select.selectByIndex(index);

    }

    //index ile window handle
    public void switchToWindow(int index) {

        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());

    }


    //File Upload Robot Class
    public void uploadFilePath(String dosyaYolu) {
        try {
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }


    //screenshot
    public void screenShot() {


        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/screenShot" + date + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //webelement screenshot
    public void screenShotOfWebElement(WebElement webElement) {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/webElementSS" + date + ".png";
        try {
            Files.write(Paths.get(dosyaYolu), webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void addScreenShotToReport() {


        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/screenShot" + date + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" + dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void addScreenShotOfWebElementToReport(WebElement webElement) {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/webElementSS" + date + ".png";
        try {
            Files.write(Paths.get(dosyaYolu), webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" + dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //js exectuor click method
    public void jsClick(WebElement webElement){
        try{
            webElement.click();
        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",webElement);
        }
    }


    //jsexecutor scroll end
    public void  jsScrollEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //jsexecutor scroll home
    public void  jsScrollHome(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JSExecutor sendkeys
    public void jsSendKeys(WebElement webElement,String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+value+"'",webElement);
    }



}
