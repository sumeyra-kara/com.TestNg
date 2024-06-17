package tests._6_FakerClass_FileTestleri;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.TestRunner;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _1_FakerClass extends TestBase {
    /*
    Faker kütüphanesi feyk degerler  olusturabilecegimiz kütüphanedir.

    Buradan deger üretebilmek icin faker class'tan bir obje olusturmaliyiz
     */
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

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();


        actions.click(firstname)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
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
