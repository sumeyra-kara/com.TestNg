package tests._5_HandleWindow_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.Set;

public class _3_ActionsClass extends TestBase {
    /*
    Actions class’i kullanilarak mouse ve klavye ile yapabilabilecek tum islevler gerceklestirilebilir.
    -  doubleClick () : WebElement’e çift tıklama yapar
    -  clickAndHold () : WebElement uzerinde click yapili olarak bizden komut bekler.
    -  dragAndDrop ():WebElement’i bir noktadan diğerine sürükler ve bırakır
    -  moveToElement (): Mouse’u objeye götürme islemini yapar.
    -  contextClick (): Mouse ile istedigimiz WebElement’e sag tiklama yapar.
    -  veya Keyboard ile yapabilecegimiz pageUp, pageDown, shift, arrowDown gibi islemler
    -  sendKeys (): Öğeye bir dizi anahtar gönderir
    -  keyDown (): Klavyede tuşa basma işlemi gerçekleştirir
    -  keyUp () : Klavyede tuşu serbest bırakma işlemi gerçekleştirir

    NOT1 : Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez.
    NOT2 :action objesi’ni bir kere olusturunca, istediginiz kadar action. ile baslayan komut yazar
          ve calismasi icin sonuna perform( ) yazariz.
          Action objesi kullanilarak baslayan her komut, calismak icin perform() bekler.
     */
    @Test
    public void test() {
        // https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String windowHandleilkSayfa = driver.getWindowHandle();

        // Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualText,expectedText);

        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept(); // ok tusuna basma anlamindadir

        // Elemental Selenium linkine tiklayalim
        WebElement element = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        element.click();
        String ikinciWindowHhandle = "";

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            if (!each.equals(windowHandleilkSayfa)){
                ikinciWindowHhandle=each;
            }
        }
        driver.switchTo().window(ikinciWindowHhandle); // bu sekilde ikinci yeni window'a gecmis oluyoruz
        String actualIkincText = driver.findElement(By.tagName("h1")).getText();
        String expectedIkinciText = "Elemental Selenium";
        Assert.assertEquals(actualIkincText,expectedIkinciText);

    }
}
