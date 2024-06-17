package tests._8_WebTables_ExcelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class _4_ReadExcel {
    @Test
    public void test1() throws IOException {

        // QaTeam1 sayfasindaki 3. satirdaki ismin mailinin "jhon@test.com" oldugunu test edin
        String dosyaYolu =System.getProperty("user.dir")+ "/src/test/java/tests/_8_WebTables_ExcelAutomation/LoginList.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        String actualMail = workbook.getSheet("QaTeam1").getRow(3).getCell(1).toString(); // kisa sekilde yapilabilir
        String expectedMail = "jhon@test.com";
        Assert.assertEquals(expectedMail,actualMail);

        // Excel'de ismi Melih Gezer ismi olan birisi olup olmadigini test edin
        int sonSatirIndeks=workbook.getSheet("QaTeam1").getLastRowNum();
        String actualIsim;
        boolean melihGezerVarMi=false;

        for (int i = 0; i <= sonSatirIndeks; i++) {
            actualIsim = workbook.getSheet("QaTeam1").getRow(i).getCell(0).toString();
            if (actualIsim.equalsIgnoreCase("Melih Gezer")){
                melihGezerVarMi=true;
                break;
            }
        }
        Assert.assertTrue(melihGezerVarMi);

        //QaTeam2 sayfasinda kullanilan satir sayisinin numarasini test etme?
        int kullanilanSatirSayisi =workbook.getSheet("QaTeam2").getPhysicalNumberOfRows(); // en son kullandigin satir
        // eger arada bosluk olsa bile bu method en sonuncu yadigin satirin numarasini verir(bosluklari atarak)
        // getLastRowNum(); ise normal bosluksuz bir exceldeki en sonuncu satir numarasini verir


        // ilk sayfadaki (test) tum isimleri ve tum bilgileri bir map olarak kaydedin
        // map icin key,value gerekli(firstname key, digerlei valur olsun)

        Map<String,String> isimlerMap = new TreeMap<>();
        Sheet sheet = workbook.getSheet("Test");

        for (int i = 1; i < sonSatirIndeks ; i++) {
            String key = sheet.getRow(i).getCell(0).toString();
            String value = sheet.getRow(i).getCell(1).toString() + "," +
                           sheet.getRow(i).getCell(2).toString() + "," +
                           sheet.getRow(i).getCell(3).toString() + "," +
                           sheet.getRow(i).getCell(4).toString();
            isimlerMap.put(key,value);
        }
        System.out.println("isimlerMap = " + isimlerMap);

        // ismi "Altan" olan var mi diye test edin

        Assert.assertTrue(isimlerMap.containsKey("Altan"));
        //Assert.assertTrue(isimlerMap.containsValue("Çökmez,Sakarya,32.0,Getir"));


    }
}
