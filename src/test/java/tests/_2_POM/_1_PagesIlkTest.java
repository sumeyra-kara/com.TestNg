package tests._2_POM;

import com.beust.ah.A;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class _1_PagesIlkTest {
    @Test
    public void amazonTest(){
        // amazon anasayfaya gidelim
        Driver.get().get("https://amazon.com.tr");

        // Nutella icin arama yapalim
        // Arama kutusunun locate'i pages sayfasinda
        //Pom'de pages sayfasindaki locatelere erismek icin pages sayfalarindan bir obje olusturulur.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedIcerik  ="Nutella";
        String actualAramaSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        // sayfayi kapatalim
        Driver.closeDriver();

    }
}
