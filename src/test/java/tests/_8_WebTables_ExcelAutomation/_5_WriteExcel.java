package tests._8_WebTables_ExcelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _5_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
        String dosyaYolu =System.getProperty("user.dir")+ "/src/test/java/tests/_8_WebTables_ExcelAutomation/LoginList.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet =workbook.getSheet("Test"); // test sayfasina geldik

        // 5.sütun olarak maas yazdiralim
        sheet.getRow(0).createCell(5).setCellValue("Maas");

        // 2. satir maas'a 50000 yazdiralim
        sheet.getRow(1).createCell(5).setCellValue("50000");

        // 8. satir maas'a 80000 yazdiralim
        sheet.getRow(7).createCell(5).setCellValue("80000");

        // 10. satir maas'a 100000 yazdiralim
        sheet.getRow(9).createCell(5).setCellValue("1000000");

        // Dosyayi kaydedelim -- simdi artik geriye dogru gidyoruz aldigimiz dosyayi
        FileOutputStream fos =new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        fis.close();
        fos.close();
        workbook.close();



    }
}
