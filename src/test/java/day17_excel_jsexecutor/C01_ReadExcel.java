package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExcel {

    @Test
    void test01() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell = workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println("cell = " + cell);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String actualCell = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        String expectedCell ="France";
        System.out.println("actualCell = " + actualCell);
        Assertions.assertEquals(expectedCell,actualCell);

        //Örnek 3: Kullanılan satır sayısını bulun
        //getPhysicalNumberOfRows() methodu ici dolu olan satirlarin sayisini verir, Sayi verdigi icin sayma sayilari 1 den baslar
        System.out.println("Kullanilan satir sayisi = " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());//11

        //Örnek 4: Sayfadaki son satırin index ini yazdırınız
        //getLastRowNum() methodu calisma sayfasindaki son satirin indexini döndürür,
        //Eger toplam 5 satir varsa bu methodu 4 return eder, index 0 dan baslar
        System.out.println("Sayfadaki son satirin indexi = " + workbook.getSheet("Sheet1").getLastRowNum());//10

        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}

        Map<String,String> countryCapitals = new HashMap<>();

        for (int i = 0; i <= workbook.getSheet("Sheet1").getLastRowNum() ; i++) {

            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String captial = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            countryCapitals.put(country,captial);
        }
        System.out.println(countryCapitals);

    }
}
