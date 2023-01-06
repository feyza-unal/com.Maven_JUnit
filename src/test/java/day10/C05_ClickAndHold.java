package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ClickAndHold extends TestBase {
    @Test
    public void clickAndHoldTest() {
//      Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

//      And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.
                clickAndHold(source). //hedefi tut
                moveToElement(target). //kaynaga surukle
                release(). //kaynagi birak
                build(). //onceki methodlarin iliskisini kur/guclendir. perform'dan once kullanilir
                perform(); //islemi gerceklestir

        waitFor(2);

// build -->  kullanilmasi sart degil fakat kullanilmadiginda methodlari baglarken kopukluk olabilir
    }
}
