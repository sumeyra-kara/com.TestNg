package tests._11_TestNGReports_ParalelTest_DataProvider;

import com.beust.ah.A;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class _4_DataProvider {

    //Data Provider TestNG'nin test methodu disindan test'e data saglamak icin olusturdugu özel bir yapidir
    //Bu yapi iki katli array döndürür

    @DataProvider
    public static Object[][] aranacaklarListesi() {
        String[][] aranacaklarArrayi = {{"Java"},{"Apple"},{"Samsung"},{"Faker"},{"Cracker"}};
        return aranacaklarArrayi;
    }

    // @DataProvider bir TestNG annotation’idir, dolayisiyla sadece TestNG ile kullanilir.
    //  DDT (Data Driven Test) konseptinde teste veri sağlamak için kullanılır

    @Test(dataProvider = "aranacaklarListesi")
    public void test(String aranacakKelime) {
        //amazon sayfasina gidin
        Driver.get().get(ConfigReader.getProperty("amazonUrl"));

        // bize test Methodu disindan list olarak verilen urunlerin hepsi icin arama kutusuna yazip arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        // ve sonuc yazisinin arattiginiz elementi icerdigini test edin
        String actualAramaSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik = aranacakKelime;
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));
        Driver.closeDriver();
    }
}
