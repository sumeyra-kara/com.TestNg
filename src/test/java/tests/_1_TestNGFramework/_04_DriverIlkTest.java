package tests._1_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class _04_DriverIlkTest {
    /*
    Page Object Model'de driver olusturmak icin inheritance ile kullandigimiz TtestBase class'i yerine,
    static yollarla ulasabilecegimiz bbir method kullanilmasi tercih edilmistir.

    Driver bizim icin cok önemli oldugunden driver icin bagimsiz bir class olusruracagiz
     */

    @Test
    public void test01(){
        //amazon ana sayfaya gidin
        Driver.get().get("https://www.amazon.com.tr");

        // Nutellla icin arama yapin
        WebElement aramaKutusu = Driver.get().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama sonuclarinin Nutella kelimesi icerdigini test edin
        WebElement sonucElementi = Driver.get().findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }
}
