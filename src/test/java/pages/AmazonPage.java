package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    /*
    Page class'lari surekli kullandigimiz locate islemleri ve varsa login gibi kücük islevleri iceren methodlar barindirir.
    Selenium ile locate islemi veya herhangi bir islev gerceklestirmek istedigimizde, WebDriver objesine ihtiyac vardir.

    Pom'da Driver class'inda olusturdugumuz WebDriver driver objesini page class'larina tanimlamak icin PageFactory
    class'indan initElements() kullanilir.
     */
    public AmazonPage(){
        PageFactory.initElements(Driver.get(),this);
        /* Bir page class’i olusturdugumuzda ilk isimiz bir constructor olusturup, pageFactory class’indan
        initElements( ) method’unu kullanmak olmalidir.
        */
        // Bu ayari constructor icine koyma sebebimiz: page sayfalarina obje olusturularak ulasildigi icin,
        // kim page sayfasini kullanmak isterse, page sayfasindan obje olusturmak icin, constructor calisacak ve
        // bu constructor'in icinde bulunan initElements() gerekli ayari yapmis olacak
    }
    //@FindBy notasyonu test class’larinda kullanacagimiz Web Elementlerini Page sayfasinda locate etmek icin kullanilir

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//div[@class='sg-col-inner'])[1]")
    public WebElement aramaSonucuElementi;


}
