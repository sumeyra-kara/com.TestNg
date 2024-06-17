package tests._2_POM;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
public class _6_qualitydemyNegatifLoginTest {
    @Test
    public void gecersizIsimSifreTesti(){
        //Oualitydemy ana sayfaya gidin
        Driver.get().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecersiz username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.eMailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.eMailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }
    @Test(groups = "smoke")
    public void gecersizIsimTesti(){
        //Oualitydemy ana sayfaya gidin
        Driver.get().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecersiz username ve gecerli sifreyi ilgili kutulara yazin
        qualitydemyPage.eMailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.eMailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }
    @Test
    public void gecersizSifreTesti(){
        //Oualitydemy ana sayfaya gidin
        Driver.get().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // gecerli username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.eMailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.eMailKutusu.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
