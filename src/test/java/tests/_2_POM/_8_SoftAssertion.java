package tests._2_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _8_SoftAssertion {
    @Test
    public void hardAssertion() {
        /*
        Assert islemi ilk failed oldugunda  Selenium calismayi durdurur ve AssertionError verir.

        Eger bir test methodu icinde birden fazla assertion varsa ilk failed olanda calisma durur,sonraki
        assertion calismamis olur.

        TestNG bu konuda bize daha fazla kontrol yetkisi vermistir.
        Istersek TestNG assertion failed olsa bile bizim istedigimiz satira kadar kodlarin calismaya devam
        etmesini saglar. "artik rapor ver" dedigimizde failed olan tüm assertion'lari raporlar ve failed olan varsa
        calismayi durdurur.
         */

        int sayi = 24;
        Assert.assertTrue(sayi%2== 0,"sayi cift bir sayi olmali"); // sayi cift mi?
        Assert.assertTrue(sayi > 100); // sayi 100'den büyük mü?
        Assert.assertTrue(sayi  < 1000);
        Assert.assertFalse(sayi%3 == 0);
    }

    @Test
    public void softAssertionTest() {
        /*
        SoftAssert(verification) class'i sayesinde assertAll()'un calisacagi satira kadar tüm assertionlar calismaya devam eder
        (failed olan olsa bile)
        AssertAll() calistiginda failed olan assertion'lara ait raporu verir.Ancak hangi satirda oldugunu vermez.
        Selenium hata mesaji da assertAll()'un bulundugu satiri isaret eder.
        Failed olan assertion'lari kolaylikla bulmak icin yanina hata mesajini da eklemeliyiz.
         */
        int sayi = 24;

        SoftAssert softAssert = new SoftAssert(); // obje olusturuyoruz önce
        // obje olusturdugumuz icin bunlar static degildir

        softAssert.assertTrue(sayi%2== 0,"sayi cift olmali"); // sayi cift mi?
        softAssert.assertTrue(sayi > 100, "sayi 100'den buyuk olmali"); // sayi 100'den büyük mü?
        softAssert.assertTrue(sayi < 1000,"sayi 1000'den kucuk olmali");
        softAssert.assertFalse(sayi %3 == 0,"sayi 3'e tam bölünebilmeli");

        softAssert.assertAll(); // durum raporlaramasini isteyelim
        // negatif yanina kac tane failed oldugunu verir ancak hata hangilerinde oldugunu bilemeyiz

        // softAssert objesi ile assertionlari yaptiktan sonra assertAll() kullanmazsaniz, direk passed olur
        // failed olan assertionlar kullanilamaz.
    }
}
