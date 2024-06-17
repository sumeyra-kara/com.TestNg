package tests._2_POM;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class _7_DriverSonHali {
    //3 tane test methodu olusturalim
    //1. ethod'da amazona gidip, url'in amazon icerdigini test edin
    @Test
    public void amazonTest() {
        Driver.get().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik ="amazon";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }

    //2. methodda wiseQuarter' anasayfaya gidip, title'nin wiseqaurter icermedigini test edin
    @Test
    public void wiseTest() {
        Driver.get().get(ConfigReader.getProperty("wiseUrl"));
        String expectedIcerik = "wisequarter";
        String actualTitle = Driver.get().getTitle();
        Assert.assertFalse(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();
    }

    //3 methodda facebook anasayfaya gidip, title'nin facebook icermedigini test edin
    @Test
    public void facebookTest() {
        Driver.get().get(ConfigReader.getProperty("facebookUrl"));
        String expectedIcerik = "facebook";
        String actualTitle = Driver.get().getTitle();
        Assert.assertFalse(actualTitle.contains(expectedIcerik));
        Driver.closeDriver();
    }
    // her method'Da yeni driver olusturp, method sonunda driver'i kapatin
}
