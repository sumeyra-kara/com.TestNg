package tests._4_TestBase_JsAlerts_iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _4_iFrame extends TestBase {
    /*
    HTML kodlarda kullanilan <iframe> tag’i bir HTML sayfasinin icerisine baska bir HTML sayfasi
    gömmek(embed) icin kullanilir. Nested HTML kodlari gibi.
    <iframe> tag’i icerisinde header ve body bulunur.

    https://html.com/tags/iframe/ --- mesela burada youtube videosunda

    bir html sayfasinin icinde normalde bir tane html,head ve body olur. ama parent bu olacak sekilde ic ice de olabilir.
    icice birden fazla olabilir.
    Bir websayfasinda locate islemi dogru yapildigi halde istenen webelement’e ulasilamiyorsa,
    aranan elementin bir iframe icinde olup olmadigi kontrol edilmelidir.
    Bir iframe icerisindeki webelementi kullanabilmek icin driver’i iframe’e switch yapmak gereklidir.

    Webdriver’i istenen iframe’e switch yapabilmek icin iframe’i driver’a tanitmak gerekir. Bu tanitma
    3 farkli yolla yapilabilir.
        1) Iframe’i webelement olarak locate ederek
           driver.switchTo().frame(iframeElementi);
        2) Iframe’in id veya name attribute value’su kullanilarak
        3) Iframe’in index’i biliniyorsa, index kullanilarak

      1**  driver.switchTo().parentFrame() :  ic ice birden fazla iframe varsa bir uste cikar
      2**  driver.switchTo().defaultContent() : direk anasayfaya cikar.

     */

    @Test
    public void test()  {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
         driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iFrameYaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameYaziElementi.isDisplayed());
        System.out.println("iFrameYaziElementi.getText() = " + iFrameYaziElementi.getText());

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);
        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba Dunya!");

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        /*
        iframe'e gecis yapilinca oradan cikis yaptirana kadar iframe'in icinde kalir.
        driver.switchTo().parentFrame() :  ic ice birden fazla iframe varsa bir uste cikar
        driver.switchTo().defaultContent() : direk anasayfaya cikar.
         */
       // driver.switchTo().parentFrame(); // bir usttekine cikar
        driver.switchTo().defaultContent() ; // direk anasayfaya cikar.
        // iframe'De eger girdiysek cikmamiz gerekir yoksa hata verir
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println("elementalSelenium.getText() = " + elementalSelenium.getText());
    }
}
