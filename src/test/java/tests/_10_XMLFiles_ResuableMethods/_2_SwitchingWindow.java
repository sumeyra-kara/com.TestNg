package tests._10_XMLFiles_ResuableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class _2_SwitchingWindow {
    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.get().get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın
        SoftAssert softAssert = new SoftAssert();

        WebElement openingWindowYaziElementi = Driver.get().findElement(By.tagName("h3"));
        String expectedYazi  ="Opening a new window";
        String actualYazi = openingWindowYaziElementi.getText();
        softAssert.assertEquals(actualYazi,expectedYazi,"ilk sayfa text testi Opening a new window");

        String ilkSayfaHandleDegeri  =Driver.get().getWindowHandle();

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = Driver.get().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title The Internet olmali");

        // Click Here butonuna basın.
        WebElement clickHere = Driver.get().findElement(By.xpath("//*[text()='Click Here']"));
        clickHere.click(); // burada artik yeni window acildi, artik 2 window var

        ReusableMethods.switchToWindow("New Window"); // iinci sayfaya geciyor


        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedNewTitle = "New Window";
        String actualNewTitle = Driver.get().getTitle();
       softAssert.assertEquals(actualNewTitle,expectedNewTitle);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newtext = Driver.get().findElement(By.tagName("h3"));
        System.out.println("text.getText() = " + newtext.getText());
        String expectedText  = "New Window";
        String actualText = newtext.getText();
        softAssert.assertEquals(actualText,expectedText);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        Driver.get().switchTo().window(ilkSayfaHandleDegeri);
        String expected= "The Internet";
        String actual = Driver.get().getTitle();
        softAssert.assertEquals(actual,expected);

        softAssert.assertAll(); // tüm raporlari bize verir

    }
}
