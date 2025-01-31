package day16_extentreport_webtable_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    void test01() throws IOException {
        //1) Projectimizde excel dosyasinin bulundugu yerin pathini almaliyiz
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        //2)FileInputStream classindan bir object olusturarak excel dosyasından
        //classimiza data akısı olustururuz
        FileInputStream fis  =new FileInputStream(dosyaYolu);
        //3)fis objesi üzerinden bir excel dosyasini temsilen bir workbook objecti olusturduk
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(0);//index 0 dan baslar
        Cell cell = row.getCell(0);
        System.out.println("cell = " + cell);
    }

    @Test
    void test02() throws IOException {
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis  =new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));
    }


}
