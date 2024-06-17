package tests._4_TestBase_JsAlerts_iFrame;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClass;

public class _2_JsAlerts extends TestBaseBeforeClass {
    /*
     ALERT; Alert kullanıcıya bir tür bilgi vermek veya belirli bir işlemi gerçekleştirme izni istemek
     için ekran bildirimi görüntüleyen küçük bir mesaj kutusudur. Uyarı amacıyla da kullanılabilir.

     Otomasyon yaparken iki türlü alert ile karsilasabiliriz.
    1- HTML alerts :
    HTML kodlari ile lusturulmus alertlerdir. Html ile olusturuldugu icin inspect edilebilir, locate edilebilir
    ve driver ile kullanilabilir. extra isleme gerek yoktur.

    2-JavaScript alert :
    Inspect yapilamaz, locate edilemez. ekstra isleme ihtiyac vardir.
    Testlerimiz sorasinda JS alert ile karsilasirsak driver.switchto().alert() methodlarini kullanarak
    alert'e gecis yapabilir ve alert üzerinde OK,cancel, Alert yazisini alma getText() ve alert'e yazi gonderme
    sendKeys() methodlarini kullanabiliriz.

    1.Simple Alert : Bu basit alert ekranda bazı bilgiler veya uyarılar görüntüler. Ok denilerek kapatilir
    2. Confirmation Alert : Bu onay uyarısı bir tür işlem yapma izni ister. Alert onaylaniyorsa OK,
                            onaylanmiyorsa Cancel butonuna basilir.

    3.Prompt Alert : Bu Prompt Uyarısı kullanıcıdan bazı girdilerin girilmesini ister ve selenium webdriver metni
                     sendkeys ("input….") kullanarak girebilir.

      ********
      1***** accept() : Alert üzerindeki OK butonuna basmak için kullanılır.
      2***** dismiss() : Alert üzerindeki Cancel butonuna basmak için kullanılır. (yani ok dememek icin)
      3***** getText() : Alert üzerindeki yaziyi döndürür.
      4***** sendKeys(“istenen yazi” ) : Alert üzerindeki text kutusuna istenen metni yazdırır.
     */

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        // 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);

         // Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText(); // alert'e gidip text'ini aliyor bize
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

         // OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept(); // okey demek icin accept() kullanilir.
        // accept() : Alert üzerindeki OK butonuna basmak için kullanılır.
    }

    @Test
    public void test2() {
        //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //  2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //  Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        // Dismiss() : Alert üzerindeki Cancel butonuna basmak için kullanılır.
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }

    @Test
    public void test3() {
        //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        //  Cikan prompt ekranina "Abdullah" yazdiralim
        String isim = "Abdullah";
        driver.switchTo().alert().sendKeys(isim); // .getText( ) : Alert üzerindeki yaziyi döndürür.

        // OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //  Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonucYazisi = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

    }
}
