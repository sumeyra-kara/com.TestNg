package tests._5_HandleWindow_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class _6_ActionClassKeyDownKeyUp extends TestBase {
    /*
    Klavyede cok fazla tus vardir ama tum tuslar 3 temel islev ile kontrol edilebilir.
    1 ) sendKeys (): Öğeye bir dizi anahtar gönderir
    2 ) keyDown (): Klavyede tuşa basma işlemi gerçekleştirir
    3 ) keyUp () : Klavyede tuşu serbest bırakma işlemi gerçekleştirir
     */


    @Test
    public void test() {
        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com.tr");

        // Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        Actions actions =new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();// harf ile birlikte schift'e basinca onu büyük harf yapar

        // aramanin gerceklestigini test edin
        WebElement element = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik ="Samsung A71";
        String actualIcerik  = element.getText();
        System.out.println("actions = " + actions);
    }
}
