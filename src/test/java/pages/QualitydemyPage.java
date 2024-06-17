package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class QualitydemyPage {
    public QualitydemyPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-sign-in-simple']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement eMailKutusu;

    @FindBy (xpath = "//input[@id='login-password']")
    public WebElement passwordKutusu;

    @FindBy (xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginButonu;

    @FindBy (xpath = "//a[text()='Instructor']")
    public WebElement basariliGirisKontrolElementi;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public  WebElement cookies;

}
