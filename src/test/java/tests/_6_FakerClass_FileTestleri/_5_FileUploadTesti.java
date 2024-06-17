package tests._6_FakerClass_FileTestleri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _5_FileUploadTesti extends TestBase {
    /*
    driver ile gittigimiz webSayfasinda bilgisayarimizdaki bir dosyayi upload etmek istersek bilgisiyaramizdaki
    klasörlere erismemiz gerekir. bunun yerine 3 adimla su islemleri yapariz :
        1- Dosya yolunu olusturup kaydedin (mumkunse dinamik olsun)
        2- Choose file butonunu locate edip dosya yolunu bu element’e gonderin
        3- Upload butonunu locate edip tiklayin

     */

    @Test
    public void test() {
        // https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonunu kullanarak projemizdeki deneme.txt dosyasini secelim
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String herkesteFarkli = System.getProperty("user.dir"); // proje altinda oldugu icin user.dir kullaniyouz
        String herkesteAyniOlan ="/src/test/java/tests/_6_FakerClass_FileTestleri/deneme.txt";
        String dosyaYolu = herkesteFarkli+herkesteAyniOlan;
        chooseFile.sendKeys(dosyaYolu);

        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadElementi.isDisplayed());

    }
}
