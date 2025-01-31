package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    void test01() throws IOException {

        //classwork
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        String path ="src/test/java/resources/smoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(2).setCellValue("STATUS");
        workbook.getSheet("Sayfa1").getRow(1).createCell(2).setCellValue("valid");
        workbook.getSheet("Sayfa1").getRow(2).createCell(2).setCellValue("valid");
        workbook.getSheet("Sayfa1").getRow(3).createCell(2).setCellValue("invalid");

        //Dosyaya yazmak icin cikis akisi olusturduk
        FileOutputStream fos = new FileOutputStream(path);
        //workbook a değisiklikleri yazdik
        workbook.write(fos);

        fis.close();
        fos.close();
    }

    /*HOMEWORK
    Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
      ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
     */



}
