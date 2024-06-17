package tests._1_TestNGFramework;

import org.testng.annotations.Test;

public class _01_Priority {
    /*
    JUnit framework'de testlerin calisma sirasi ÖNGÜRELEMEZ ve DÜZENLENEMEZ

    TestNg testleri harf sirasina göre calistirir(alfabetik sirasi ile) (ÖNGÖRÜLEBILIR)

    Ayrica priority degeri girerek testleri istedigimiz sira ile de calistirabiliriz
    (Kontrol edilebilir siralama)

    priority sayisal olarak kücükten büyüge dogru testleri calistirir.
    Eger priority degeri ayni olan birden fazla test varsa, o zaman yine harf sirasina bakar.


     */

    @Test(groups = "minireg1")
    public void  youtubeTesti(){
        System.out.println("Youtube Testi");
    }

    @Test(priority = -3)
    public void wiseTesti(){
        System.out.println("Wise Testi");
    }

    @Test(groups = {"smoke","minireg1"})
    public  void amazonTesti (){ // priority yazilmazsa 0 degeri alir
        System.out.println("Amazon Testi");
    }
}
