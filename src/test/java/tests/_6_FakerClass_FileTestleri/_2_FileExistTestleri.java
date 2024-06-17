package tests._6_FakerClass_FileTestleri;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class _2_FileExistTestleri {
    /*
    getProperty( ) method’u iki farkli parametre ile calisabilir.

    1- System.getProperty ( "user.dir"); icinde bulunulan klasörün yolunu (Path) verir
    2- System.getProperty ( "user.home"); bilgisayarimizda bulunan user klasörünü verir

    . https://the-internet.herokuapp.com/download adresine gidelim.
     */

    @Test
    public void test1() {
        // com.TestNg projesi icerisinde deneme.txt dosyasinin var oldugunu test edin

        String dosyaYolu = "src/test/java/tests/_6_FakerClass_FileTestleri/deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
