package tests._11_TestNGReports_ParalelTest_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class _1_RaporluAmazonSearch extends TestBaseRapor {
    @Test
    public void test1() {
        extentTest=extentReports.createTest("Amazon arama testi","kullanici istedigi kelimeyi aratabilmeli");
        // amazon'a gidin
        Driver.get().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici ana sayfaya gider");

        // Nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        extentTest.info("arama kutusuna belirli aranacak kelimeyi yazar ve aratir");

        // arama sonuclarinin Nutella icerdigini test edin
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik =ConfigReader.getProperty("amazonExpectedIcerik");
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        extentTest.pass("belirlenen aranacak kelime aratildiginda, arama sonucuda expected icerik oldugu test edilir");
        Driver.closeDriver();


    }
}
