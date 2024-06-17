package utilities;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseRapor {

    protected static ExtentReports extentReports; // extent report'a ilk atamayi yapar
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder
    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler

    // Test islemine baslamadan önce(test methodundan önce degil,tüm test isleminden önce)
    @BeforeTest(alwaysRun = true) //alwaysRun : her zaman calistir demek
    public void setUpTest(){
        extentReports = new ExtentReports(); // raporlamayi baslatiir
        // rapor olustuktan sonra raporunuz nereye eklensin istiyorsaniz buraya yaziyorsunuz

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/Rapor"+date+".html";
        //olusturmak istedigimiz raporu(html formatinda) baslatiyoruz, filePath ile dosya Yolunu belirliyoruz
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // istediginiz bilgileri buraya ekleyebiliyorsunuz
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser",ConfigReader.getProperty("browser")); //chrome,firefox--
        extentReports.setSystemInfo("Automation Engieer","Sevgi");
        extentHtmlReporter.config().setDocumentTitle("TestNG Test");
        extentHtmlReporter.config().setReportName("TestNG Reports");

    }

    // Her test methodundan sonra eger testte hata varsa, ekran görüntüsünü alip rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public  void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){ // eger testin sonucu basarisiz olursa
            String screenshotLocation= ReusableMethods.takeScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        }else if (result.getStatus()==ITestResult.SKIP){ // eger test calistirilmadan gecilmezse
            extentTest.skip("Test Case is skipped : " + result.getName()); // Ignore olanlar
        }

        Driver.closeDriver();
    }


    // Raporlandirmayi sonlandirmak icin

    @AfterTest(alwaysRun = true)
    public void tearDownTest(){
        extentReports.flush();
    }

}