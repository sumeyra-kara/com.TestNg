package tests._3_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class _4_DropDownTask {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
         driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // index kullanarak Secenek1(Option 1)'i secin ve yazdirin
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownElement);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3);

        // Value kullanarak secenek2 'yi secin ve yazdirin
        select.selectByValue("2");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        // Visible Text(görünen Metin) kullanarak secenek1'i secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        // Tüm dropdown degerleri(value) yazdirin
        List<WebElement> optionList = select.getOptions();
        for (WebElement each : optionList){
            System.out.println("each.getText() = " + each.getText());
        }

        // Dropdown boyutunun 3 oldugunu test edin
        int expectedSize = 3;
        int actualSize = optionList.size();
        Assert.assertEquals(expectedSize,actualSize);
    }
}
