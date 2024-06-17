package tests._11_TestNGReports_ParalelTest_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseRapor;

public class _2_RaporluSoftAssert extends TestBaseRapor {
    @Test
    public void test1() throws InterruptedException {

        extentTest= extentReports.createTest("Alert Test","Kullanici JS Alert'leri calistirabilmeli ve kapatabilmeli");
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.get().get("https://the-internet.herokuapp.com/javascript_alerts");
        extentTest.info("kullanici herokkuapp alerts sayfasina gider");
        Thread.sleep(3000);

        // 1.alert'e tiklayin
        WebElement ilkAlertElementi = Driver.get().findElement(By.xpath("//button[text()='Click for JS Alert']"));
        ilkAlertElementi.click();
        extentTest.info("ilk alert butonuna click yapar");
        Thread.sleep(3000);

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = Driver.get().switchTo().alert().getText(); // alert'e gidip text'ini aliyor bize
        SoftAssert softAssert = new SoftAssert();
        extentTest.info("softasert ile alert yazisinin beklenen degere sahip oldugunu test eder");

        //Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        softAssert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"alertteki yazi belirtilenden farkli");

        // OK tusuna basip alert'i kapatin
        Driver.get().switchTo().alert().accept(); // okey demek icin accept() kullanilir.
        extentTest.info("alert kapatildi");

        // alertin kapatildigini test edin
        //Assert.assertTrue(ilkAlertElementi.isEnabled());
        softAssert.assertTrue(ilkAlertElementi.isEnabled(),"alert kapatilamadi");
        extentTest.info("soft assert ile alertin kapatildigini test eder");

        softAssert.assertAll();
        extentTest.pass("soft assert ile yapilan tum testlerin sonucunu raporlar");

        Driver.closeDriver();
        extentTest.info("sayfayi kapatir");

    }
}
