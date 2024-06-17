package tests._9_GetScreenshot_JsExecutors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class _2_WebElementScreenshot extends TestBase {
    /*
    Yine 4 adimda yapilir
    1. istenen web elemnet locate edilir
       WebElement sonucYaziElementi = driver.findElement(By.id("twotabsearchtextbox"));
    2. path ile yeni foile olusturalim
       File istenenElementSShot=new File ("target/ScreenShot/yaziscreenshot.png")
    3. Istenen webelement’i kullanarak getScreenshotAs( ) methodunu calistiralim ve gelen resmi gecici bir file’a assign edelim
        File geciciResim  =sonucYaziElementi.getScreenshotAs(OutputType.FILE);
    4. ecici resmi, saklamak istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,tumSayfaFotograf);
     */

    @Test
    public void test() {
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

        //Rapora eklenmek uzere,sonuc elementinin ekran görüntüsünü alalim
        ReusableMethods.webElementFotografCek(driver,sonucElementi);
        ReusableMethods.tumSayfaFotografCek(driver); // ya da tum sayfanin da fotosunu cekebiliriz
    }
}
