package tests._2_POM;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class _8_SingletonPattern {

    @Test
    public void test() {
        /*
        Otomasyon icin driver class'indaki webDriver driver objesini kullaniyoruz.Ancak driver'in bizim
        istedigimiz islemleri yapabilmesi icin önceliklle getDriver() icinde yaptigimiz atama islemlerine
        ihtiyac vardir

        Bir framework'de calisan kisilerin getdriver() kullanmadan direk driver objesine erisimini engellemek icin
        Singleton Pattern kullanimi TERCIH EDILMISTIR

        Singleton Pattern bir class'Dan obje olusturulmasini ve o obje ile class'daki class üyelerine ersimi engellemek
        icin kullanilir.

        OOP konsept cercevesinde Driver cllass'ini farkli yontemlerle kullanabilirsiniz. Ekip calismasinin
        tek düzen üzerinden gitmesi önemli oldugundan

         */
        //Driver.driver.get(ConfigReader.getProperty("amazonUrl"));
        // getDriver() calismadigindan driver null olarak isartelendiginden NullPointerException verir

       //  Driver driver = new Driver(); ---
        // Driver cllas'indaki constructor'u private yapinca artik kimse obje olusturamaz!
        // driver.get("dsggfd")

        //driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }
}
