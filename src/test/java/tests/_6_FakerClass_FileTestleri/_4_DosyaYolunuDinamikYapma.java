package tests._6_FakerClass_FileTestleri;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class _4_DosyaYolunuDinamikYapma {


    @Test
    public void test() {
        // herkesin bilgisayarinda dosya yolu oldugundan, herkesin dosya yolu farkli olur
        // dosya yolunu dinamik hale getirmek icin java'Dan yardim alacagiz.

        System.out.println(System.getProperty("user.dir")); // icinde bulunulan klasörün yolunu (Path) verir
        //C:\Users\User\IdeaProjects\com.TestNg


        System.out.println(System.getProperty("user.home")); // bilgisayarimizda bulunan user klasörünü verir
        // C:\Users\User


        /*
        ARTIK DINAMIK YAPIYORUZ
         */
        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluHerkesteAyniOlan = "\\Downloads\\logo.png";

        String dosyaYolu = dosyaYoluDegisenKisim+dosyaYoluHerkesteAyniOlan;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        // ayni islemi deneme.txt icin yapsak;
        // src/test/java/tests/_6_FakerClass_FileTestleri/deneme.txt
        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluHerkesteAyniOlan="/src/test/java/tests/_6_FakerClass_FileTestleri/deneme.txt";
       dosyaYolu = dosyaYoluDegisenKisim+dosyaYoluHerkesteAyniOlan;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
