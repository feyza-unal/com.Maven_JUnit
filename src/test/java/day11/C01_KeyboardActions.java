package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {
    @Test
    public void keyboardActions() {

//      Google a gidin https://www.google.com
        driver.get("https://www.google.com");

//      ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
//      ‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
//      Ve ENTER tusuna bas

        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.name("q"));

        actions.
                keyDown(searchBox, Keys.SHIFT). //arama kutusunda shift tusuna bas
                sendKeys("iPhone X fiyatlari"). // shifte basiliyken yaz
                keyUp(searchBox, Keys.SHIFT).  // shifte artik basma
                sendKeys(" cok pahali!" + Keys.ENTER). //yazip entera bas
                build(). //1den fazla actions methodu kullanildiginda build() kullanilmasi onerilir
                perform();


        waitFor(2);

    }
}
