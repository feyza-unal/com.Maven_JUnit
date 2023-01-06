package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {
    @Test
    public void dragAndDropTest() {
//      Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); // kaynak ve hedef iframe'in icinde

//      And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.
                dragAndDrop(source,target).
                perform();

        waitFor(2);

    }

}
