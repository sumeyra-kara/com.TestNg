package tests._9_GetScreenshot_JsExecutors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class _1_SayfaTamamiScreenshot extends TestBase {
    /*
    4 adim gereklidir:
    1. adim :  Bir TakeScreenhot objesi olusturup driver’imizi TakeScreenhot’a cast yapalim
                TakesScreenshot tss = (TakesScreenshot) driver;
    2. adim :  kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin path ile yeni bir File olusturalim
                File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");
    3. adim :  Takescreenshot objesini kullanarak getScreenshotAs( ) methodunu calistiralim ve gelen resmi
                gecici bir file’a assign edelim
                File geciciResim = tss.getScreenshotAs(OutputType.FILE);
    4. adim :  Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalayalim
                FileUtils.copyFile(geciciResim,tumSayfaResim);

     */


    @Test
    public void test() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://www.amazon.com.tr");

        // Nutella aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualSonucYazisi = sonucElementi.getText();
        String expectedSonucYazisi = "Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

        //Rapora eklenmek uzere,tüm sayfanin ekran görüntüsünü alalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaResim); //  Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalamak

        ReusableMethods.tumSayfaFotografCek(driver); // method kullanarak
    }
}
