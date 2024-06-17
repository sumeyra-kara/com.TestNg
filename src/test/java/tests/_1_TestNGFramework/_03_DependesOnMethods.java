package tests._1_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_DependesOnMethods {
    /*

    DependsOnMethod öncelik sirasina karismaz.
    Bu method bir test method'un calismasini baska bir method'un calisip passed olmasina baglar.

    Baglanilan method calismaz veya calisir ama failed olursa baglanan method hic calismaz

    @Test notasyonu sayesinde her test bagimsiz olarak calistirilabilir.
    Ancak bir test dependensOnMethod ile baska bir method'a baglanmis ise tek basina calismasi istendiginde, önce
    bagli oldugu test method'unu calistirir. o method calisip passed olursa asil calistirmak istedigimiz
    method da calisir.

    Bu baglanti 3 ceya daha fazla method arasinda olursa, yani calistirmak istedigimiz method baska bir metod'a bagliysa
    ücü birden calismaz. "No tests were found" yazar ve hicbir test method'u calismaz.

     */

    @Test(dependsOnMethods = "wiseTesti")
    public void youtubeTesti(){
        System.out.println("Youtube Testi");
        Assert.assertTrue(8==8); // passed
    }

    @Test(priority = 3)
    public void wiseTesti(){
        System.out.println("Wise Testi");
    }

    @Test(dependsOnMethods = "youtubeTesti")
    public  void amazonTesti (){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon Testi");
    }

    /*
    Youtube Testi
    Amazon Testi
    Wise Testi
     */
}
