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

public class _1_CheckBox {
    /*
    * web sayfasina gidin
    *
    *
     */

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
    public void checkboxtest () throws InterruptedException {
        // web sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // CheckBox1 ve Checkbox2 elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Thread.sleep(3000);

        // Checkbox1 secili degilse onay kutusunu tiklayin
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(3000);

        // Checkbox2 secili degilse onay kutusunu tiklayin
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        Thread.sleep(3000);

        // CheckBox1 ve Checkbox2'nin secili oldugunu test edin
        Assert.assertTrue(checkBox1.isSelected() && checkBox2.isSelected());

    }

}
