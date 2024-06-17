package tests._5_HandleWindow_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _5_Actions extends TestBase {
    @Test
    public void test() {
        //  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com.tr");

        // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement element = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        // “Create a list” butonuna basin
        WebElement creatAList = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        creatAList.click();

        // Acilan sayfada “Listelerim” yazisi oldugunu test edin
        WebElement yourList = driver.findElement(By.xpath("//div[@role='heading']"));
        String actualText = yourList.getText();
        String expectedText ="Listelerim";
        Assert.assertEquals(actualText,expectedText);
    }
}
