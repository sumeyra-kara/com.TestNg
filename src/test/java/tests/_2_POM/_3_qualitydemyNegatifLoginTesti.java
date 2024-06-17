package tests._2_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;


public class _3_qualitydemyNegatifLoginTesti {

    @Test
    public void test() throws InterruptedException {
        //qualitydemy anasayfaya gidin
        Driver.get().get("https://www.qualitydemy.com");

        // ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        Thread.sleep(4);

        // kullanici adi olarak selenium yazin
        qualitydemyPage.eMailKutusu.sendKeys("selenium");
        Thread.sleep(4);

        // password olarak heyecandir yazin
        qualitydemyPage.passwordKutusu.sendKeys("heyecandir");
        Thread.sleep(6);

        // cookiesleri kabul edelim
        qualitydemyPage.cookies.click();
        Thread.sleep(3);

        //login butonuna tiklayin
        qualitydemyPage.loginButonu.submit();
        Thread.sleep(4);

        // giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.eMailKutusu.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
    }
}
