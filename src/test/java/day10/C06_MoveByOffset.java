package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_MoveByOffset extends TestBase {
    @Test
    public void moveByOffsetTest() {
//      Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

//      And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));

        actions.
                clickAndHold(source).
                moveByOffset(150,20).
                release().
                build().
                perform();

        waitFor(2);
    }
}
