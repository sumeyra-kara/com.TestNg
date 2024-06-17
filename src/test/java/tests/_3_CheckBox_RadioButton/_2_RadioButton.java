package tests._3_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class _2_RadioButton {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void radioButtonTest () throws InterruptedException {
        //Web sayfasina gidin
        driver.get("https://facebook.com");
        Thread.sleep(4000);

        //Cookies'i kabul edin
        WebElement cookies = driver.findElement(By.xpath("//button[@title='Alle Cookies erlauben']"));
        cookies.click();
        Thread.sleep(2000);

        //Create an account buton'una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        Thread.sleep(2000);

        //Radio Button elementlerini locate edin ve size uygun olani secin
        WebElement weiblichElementi = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement mannlichElementi = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement diversElementi = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        Thread.sleep(2000);
        weiblichElementi.click();

        // Sectiginiz radio button'un secili, ötekilerin secili olmadigini test edin
        Assert.assertTrue(weiblichElementi.isSelected());
        Assert.assertFalse(mannlichElementi.isSelected());
        Assert.assertFalse(diversElementi.isSelected());

    }

}
