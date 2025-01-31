package day15_exception_screenshots;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C04_ExtentReport extends TestBase {


    @Test
    void template() {
        createExtentReport("My First Extent Report");

        //Raporda testin basarili oldugunu belirtir ve PASS notu ekler
        extentTest.pass("PASS");

        //Testimizle ilglii rapora yansitmak istedigimiz bilgileri ekleriz
        extentTest.info("BILGILENDIRME NOTU");

        //Raporda testin basarisiz oldugunu belirtir ve FAIL MESAJI notu ekler
        extentTest.fail("FAIL MESAJI");

        //Rapora dikkat edilmesi gereken önemil bir konuyu yansitmak icin kullanilir
        extentTest.warning("UYARI MESAJI");

        //Test sirasinda ciddi bir hata oldugunu belirtir ve parantez icindeki metni rapora yansitir
        extentTest.fatal("CIDDI HATA MESAJI");

        //Extent report olusturmasi icin flush() methodunu kullanmaliyiz aksi halde rapor olusmaz
        extentReports.flush();
    }


}
