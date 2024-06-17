package tests._4_TestBase_JsAlerts_iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _1_TestBaseIlkClass extends TestBase {
    // Eger beforeMethod vs yoksa extends TestBase ile before After methodlara ulasabiliriz ( OOP konsepti ile)
    @Test
    public void test1() {
        driver.get("https://www.amazon.com.tr");

        // nutella icin arama yapalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        // arama sonuclarinin Nutella icerdigini test edelim
        String expectedIcerik  ="Nutella";
        String actualIcerik = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
