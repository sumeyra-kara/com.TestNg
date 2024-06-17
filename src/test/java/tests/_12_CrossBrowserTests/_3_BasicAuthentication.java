package tests._12_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class _3_BasicAuthentication extends TestBaseCross {
    @Test
    public void test() {
        // https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        // asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        // Html komutu : https://username:password@URL
        // Username : admin
        // password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratYaziElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratYaziElementi.isDisplayed());

    }
}
