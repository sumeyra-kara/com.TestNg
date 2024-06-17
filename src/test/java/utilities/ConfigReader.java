package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    static Properties properties;
    static {
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu); //configration.properties e ulasmak icin yazilir
            properties = new Properties();
            properties.load(fis); // conf.properties'ten alinan bilgileri properties objesine yüklemek(load)
        } catch (IOException e){
            System.out.println("properties dosyasi okunamadi");
        }
    }
    public static String getProperty (String key){ //(biz ona key verecegiz)

        return properties.getProperty(key); // o da bize key'e ait bilgiyi verecek
    }




}
