package tests._5_HandleWindow_ActionClass;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _1_NewWindow extends TestBase {
    /*
    driver.switchTo().newWindow(WindowType.TAB); driver otomatik olarak yeni sayfaya gecer.

    Eger görevimizde yeni window'a gittikten sonra window'lar arasi gecis islemi varsa üzerinde calsitigimiz
    window'larin windowHandle degerlerini kaydetmekte fayda vardir
     */

    @Test
    public void test1() throws InterruptedException {
        //gerekli ayarlamalari yapip, amazon sayfasina gidin
        driver.get("https://www.amazon.com.tr");
        String ilkSayfaHandleDegeri =  driver.getWindowHandle();

        // title'in amazon kelimesi icerdigini test edin
        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));

        // yeni bir tab acarak wisequerter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");
        String ikinciSayfaHandleDegeri =  driver.getWindowHandle();

        // url'nin wisequerter icerdigini test edin
        String expetedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expetedUrl));

        // tekrar amazonun acik oldugu sayfaya gecin ve url'nin amazon icerdigini test edin
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Thread.sleep(3000);
        String expetedUrl2 = "amazon";
        String actualUrl2 = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl2.contains(expetedUrl2));



    }
}
