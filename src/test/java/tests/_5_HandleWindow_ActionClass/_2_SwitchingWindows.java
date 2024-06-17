package tests._5_HandleWindow_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class _2_SwitchingWindows extends TestBase {
    /*
    driver.switchTo.newWindow() kullanarak actigimiz window'a driver otomatik gecer.
    ANCAK bir link tikladigimizda biz newWindow() method'unu kullanmadan yeni window aciliyorsa
    driver eski wondow'da kalir, yeni window'a driver'i gecirebilmek icin yeni window'un WindowhandleDegerine
    ihtiyacimiz vardir.

     */
    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın
        WebElement openingWindowYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi  ="Opening a new window";
        String actualYazi = openingWindowYaziElementi.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        String ilkSayfaHandleDegeri  =driver.getWindowHandle();
        System.out.println("ilkSayfaHandleDegeri = " + ilkSayfaHandleDegeri);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        // Click Here butonuna basın.
        WebElement clickHere = driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickHere.click(); // burada artik yeni window acilldi, artik 2 window var

        Set<String> windowHandleDegerleriSeti = driver.getWindowHandles();
        String ikinciwindowHandleDeger ="";
        for (String eachWhd : windowHandleDegerleriSeti){
            if (eachWhd!=ilkSayfaHandleDegeri){
               ikinciwindowHandleDeger=eachWhd;
            }
        }
        System.out.println("ikinciwindowHandleDeger = " + ikinciwindowHandleDeger);
        // artik ikinci sayfanin windowhandleDegerine sahibim

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        System.out.println("openingWindowYaziElementi.getText() = " + openingWindowYaziElementi.getText());
        driver.switchTo().window(ikinciwindowHandleDeger);
        String expectedNewTitle = "New Window";
        String actualNewTitle = driver.getTitle();
        Assert.assertEquals(actualNewTitle,expectedNewTitle);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newtext = driver.findElement(By.tagName("h3"));
        System.out.println("text.getText() = " + newtext.getText());
        String expectedText  = "New Window";
        String actualText = newtext.getText();
        Assert.assertEquals(actualText,expectedText);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        driver.switchTo().window(ilkSayfaHandleDegeri);
        String expected= "The Internet";
        String actual = driver.getTitle();
        Assert.assertEquals(actual,expected);

    }
}
