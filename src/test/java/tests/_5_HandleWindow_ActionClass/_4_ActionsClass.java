package tests._5_HandleWindow_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _4_ActionsClass extends TestBase {
    @Test
    public void test() {
        //  https://demoqa.com/droppable adresine gidelim
        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        driver.get("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = draggable.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();

        WebElement text = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualYazi = text.getText();
        String expectedYazi = "Dropped";
        Assert.assertEquals(actualYazi,expectedYazi);

    }
}
