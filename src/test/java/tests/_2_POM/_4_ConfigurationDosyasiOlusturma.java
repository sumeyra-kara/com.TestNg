package tests._2_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class _4_ConfigurationDosyasiOlusturma {
    /*
    Pom'da hedef test class'inda manuel olarak hicbir test datasi girmemektir

    Test datalari:
    1-Kullanacagimiz WebDriver : suan Driver class'indan dinamik olarak kullaniyoruz
    2-Locate : Locate'leri pages sayfasindan dinamik olarak kullaniyoruz
    3- kullanilan url,aranan kelime,expected icerik,dogru kullanici adi, yanlis sifre vb... gibi datalar

     */
    @Test
    public void test(){
        Driver.get().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime") + Keys.ENTER);

        String expectedIcerik = ConfigReader.getProperty("amazonExpectedIcerik");
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();

    }

}
