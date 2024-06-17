package tests._3_CheckBox_RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _3_Dropdown {
    

    
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazona gidelim
        driver.get("https://www.amazon.com.tr/");
    }

    @AfterClass
    public static void teaDown() {
        //driver.quit();
    }

    @Test
    public void test1() {
        // TEST1- arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        // Element dropDown menu oldugu icin Select Class'indan olusturacagimiz obje ile ilgili methodlari kullanmaliyiz

        WebElement dropDownElementi  = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownElementi);
        int expectedOptionSayisi = 45;
        int actualOptionSayisi =select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }

    @Test
    public void test2() {
        // TEST2--
        WebElement dropDownElementi  = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownElementi);

        //Kategori menüsünden Books secenegini secin
        select.selectByVisibleText("Kitaplar");

        //Arama kutusuna Java yazin ve aratin
         WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
         aramaKutusu.sendKeys("Java" + Keys.ENTER);


        // Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText());

        // Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik ="Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


    }
}
