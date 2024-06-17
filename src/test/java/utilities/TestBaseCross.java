package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseCross {
    protected WebDriver driver;

    @Parameters("browser") // xml'Deki browser'i yakalayan sey bu
    @BeforeMethod
    public void setUp(@Optional String browser){
        driver= DriverCross.get(browser);
    }


    @AfterMethod
    public void tearDown(){
        DriverCross.closeDriver();
    }
}
