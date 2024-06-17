package tests._7_Waits_Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class _1_Waits {
    /*
    2 tür wait vardir.
    1) Java tabanli wait :
    - Thread.sleep : Javadan gelir ve kodlari yazilan sure kadar bekletir.
    Sure dolduktan sonra alt satirdan isleme devam eder.

    2) Selenium tabanli wait :
    Implicitly Wait: Sayfadaki tüm öğeler için global bir zaman aşımıdır(timeout).
    Explicitly Wait: Çoğunlukla belirli öğeler için belirli bir koşul(expected condition) için kullanılır.

     */

    @Test
    public void test() {

        // implicitly wait'in rolunu görmek icin ayarlari burada yapalim simdilik
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());

        //6. Add buttonuna basin
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMessage = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(addButton.isDisplayed());


    }
}
