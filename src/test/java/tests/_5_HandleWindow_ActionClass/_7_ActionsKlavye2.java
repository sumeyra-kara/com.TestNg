package tests._5_HandleWindow_ActionClass;

import com.beust.ah.A;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class _7_ActionsKlavye2 extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        //  https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//span[text()='Alle Cookies erlauben'])[2]")).click();

        //  Yeni hesap olustur butonuna basalim
        WebElement button = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        button.click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions =new Actions(driver);
        WebElement firstname = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        actions.click(firstname)
                .sendKeys("Sevgi")
                .sendKeys(Keys.TAB)
                .sendKeys("Sezer")
                .sendKeys(Keys.TAB)
                .sendKeys("sevgisezer@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("sevgisezer@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345678")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12").sendKeys(Keys.TAB)
                .sendKeys("Mar").sendKeys(Keys.TAB)
                .sendKeys("1990").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(5000);

    }
}
