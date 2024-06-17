package tests._12_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseCross;

public class _2_AlertsTesti extends TestBaseCross {
    @Test
    public void test1() throws InterruptedException {

        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1.alert'e tiklayin
        WebElement ilkAlertElementi = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        ilkAlertElementi.click();

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText(); // alert'e gidip text'ini aliyor bize
        SoftAssert softAssert = new SoftAssert();

        //Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        softAssert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"alertteki yazi belirtilenden farkli");

        // OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept(); // okey demek icin accept() kullanilir.

        // alertin kapatildigini test edin
        //Assert.assertTrue(ilkAlertElementi.isEnabled());
        softAssert.assertTrue(ilkAlertElementi.isEnabled(),"alert kapatilamadi");
        softAssert.assertAll();



    }
}
