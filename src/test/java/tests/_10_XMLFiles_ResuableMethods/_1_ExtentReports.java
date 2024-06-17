package tests._10_XMLFiles_ResuableMethods;

import org.testng.annotations.Test;

public class _1_ExtentReports {
    /*
    TESTNG rapor hazırlamaz.
    Extent Reports : HTML raporlama aracıdır. Bize Html raporları verir. Test adımlarını kaydetmemize
    yardımcı olur. Ayrıca ekran görüntüleri ekleyebiliriz.

    3 tane obje olusturup kullaniriz:
    1. ExtentReports extendReports; Raporlamayı başlatmak için ExtentReports'a ihtiyacımız var.
    flush( ) metodunu için ExtentReports kullanıyoruz

    2.ExtentHtmlReporter extentHtmlReporter; Bu, özel raporlara ve raporların yapılandırmasına sahip olmamıza
    yardımcı olur,html raporlarını oluşturur. Bunu raporun oluşturulacağı yolu ayarlamak için de kullanıyoruz.

    3.ExtentTest extentTest; Bilgi eklemek için. Test adımlarını eklemek için (açıklama). Günlükleri(logs) ekliyoruz.
     extentTest.info ("URL'yi Açma"); bilgi sadece adım eklemek içindir

     */

    @Test
    public void test() {

    }
}
