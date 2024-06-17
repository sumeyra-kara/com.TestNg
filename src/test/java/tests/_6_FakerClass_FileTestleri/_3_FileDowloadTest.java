package tests._6_FakerClass_FileTestleri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.FileAssert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class _3_FileDowloadTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // logo.png dosyasını indirelim
        WebElement logoElementi = driver.findElement(By.linkText("logo.png"));
        logoElementi.click();
        Thread.sleep(3000);
        // dosyayi dowloads klasörüne indirecek

        // Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu ="C:\\Users\\User\\Downloads\\logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // herkesin bilgisayarinda dosya yolu oldugundan, herkesin dosya yolu farkli olur
        // dosya yolunu dinamik hale getirmek icin java'Dan yardim alacagiz.

        System.out.println(System.getProperty("user.dir")); // icinde bulunulan klasörün yolunu (Path) verir
        System.out.println(System.getProperty("user.home")); // bilgisayarimizda bulunan user klasörünü verir

    }
}
