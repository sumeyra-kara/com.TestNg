package tests._11_TestNGReports_ParalelTest_DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class _5_DataProviderNegatifLoginTest {
    @DataProvider
    public static Object[][] YanlisKullaniciAdlarilistesi() {

        String [][] kullaniciBilgileriArrayi={{"Sevgi","1213"},{"Sezen","1466"},{"Burcu","1861"},{"Cigdem","1913"}
                                             ,{"Sezgin","1213"} ,{"Zeynep","1222"},{"Ahmet","1225"},
                                              {"Mustafa","1586"},{"Kemal","1783"},{"Cinar","4444"},};
        return kullaniciBilgileriArrayi;
    }
    // verilen 10 kullanici bilgisi ile sisteme giris yapilamadigini test edin


    @Test(dataProvider = "YanlisKullaniciAdlarilistesi")
    public void gecersizIsimSifreTesti(String kullaniciAdi,String password){
        //Oualitydemy ana sayfaya gidin
        Driver.get().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecersiz username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.eMailKutusu.sendKeys(kullaniciAdi);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.eMailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
