package tests._2_POM;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
public class _2_qualitydemyLoginTest {
    @Test(groups = "smoke")
    public void test01(){
        //Oualitydemy ana sayfaya gidin
        Driver.get().get("https://www.qualitydemy.com");
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        // login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();

        // gecerli username ve sifreyi ilgili kutulara yazin
        qualitydemyPage.eMailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");

        // login butonuna basin
        qualitydemyPage.loginButonu.submit();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisKontrolElementi.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
