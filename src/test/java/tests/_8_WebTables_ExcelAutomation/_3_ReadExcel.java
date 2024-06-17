package tests._8_WebTables_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _3_ReadExcel {
    /*
    Excel’de bir hucredeki bilgiye ulasmak icin dosya/sayfa/satir/sutun sirasiyla ilerlemeliyiz.
        * Workbook excel dosyamiz
        * Sheet Her açık excel sekmesi (Sheet1, etc)
        * Row(satir) Java, yalnızca içeride veri varsa satırları sayar. Default olarak, Java perspektifinden satır sayısı 0'dır
        * Cells (hucre) Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar
     */

    @Test
    public void test1() throws IOException {
        // bilgisayarimizda olan bir dosyaya ulasabilmek icin FileInputStream classindan obje olusturalim
        String dosyaYolu =System.getProperty("user.dir")+ "/src/test/java/tests/_8_WebTables_ExcelAutomation/LoginList.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // sonra projemize ekledigimiz POI kutuphanesini kullanarak class'imizin icinde istenen ecxel'in kopyasini olusturalim
        Workbook workbook = WorkbookFactory.create(fis); // workbook interface oldugu icin direkt obje olusturamiyoruz
        Sheet sheet = workbook.getSheet("Test"); // hangi workbook'a gitmek istedigim
        Row row = sheet.getRow(3); // indeks degerleridir.O'dan baslar. hangi indeksli satir
        Cell cell = row.getCell(2); // hangi indeksli sütuna gitmek istiyorum
        System.out.println(cell); // Antalya

        // 6. indeksteki satirin,2.indeksteki sütunun Izmir oldugunu test edin
        row= sheet.getRow(6);
        cell= row.getCell(2);
        String expectedData = "İzmir";
        // cell objesinin data türü cell,Java'da data türlerindeki variable'laro equals ile kullanamayiz
        Assert.assertEquals(cell.toString(),expectedData);

        // 5. indeksteki satirin,4.indeksteki sütunun Zara oldugunu test edin
        cell = sheet.getRow(5).getCell(4); // kisaca bu sekilde de yazilabilr(2 adim yerine)
        String actualData =cell.toString();
        expectedData = "Zara";
        Assert.assertEquals(expectedData,actualData);

        // baska bir sayfanin bilgilerini de alabiliriz
        Sheet sheet2 = workbook.getSheet("QaTeam1");
        row = sheet2.getRow(4);
        cell = row.getCell(1);
        System.out.println(cell);


    }
}
