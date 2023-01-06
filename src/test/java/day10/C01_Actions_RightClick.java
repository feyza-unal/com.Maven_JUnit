package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions_RightClick extends TestBase {
    @Test
    public void rightClick() {
//      https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu ");

//      Kutuya sag tıklayın
        Actions actions = new Actions(driver); //1
        WebElement box = driver.findElement(By.id("hot-spot")); //2
        actions.contextClick(box).perform(); //3

//      Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

//      Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();


    }
}
//1. Actions objesi olustur
//2. Elementi locate et
//3. Webelement üzerinde action gerçekleştir