package tests._1_TestNGFramework;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class _02_Ignore {
    /*
    @Ignore notasyonu
    basina yazdigi testin Ignore edilmesini saglar. Görmez bile yok kabul eder.
     */

    @Test(priority = 57)
    public void  youtubeTesti(){
        System.out.println("Youtube Testi");
    }

    @Test(priority = -3) @Ignore
    public void wiseTesti(){
        System.out.println("Wise Testi");
    }

    @Test
    public  void amazonTesti (){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon Testi");
    }
}
