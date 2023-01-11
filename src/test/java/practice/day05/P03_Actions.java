package practice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {/*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb. */

    @Test
    public void test01() {
//    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

//    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        Actions actions = new Actions(driver);
        WebElement blueBox = driver.findElement(By.id("div2"));
        actions.moveToElement(blueBox).perform();
        waitFor(3);

//    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClick = driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClick).perform();
        String doubleClickMessage = driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!",doubleClickMessage);

//    Accept ile alert'ü kapatalım
        waitFor(2);
        driver.switchTo().alert().accept();

//    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement sourceBox = driver.findElement(By.id("draggable"));
        WebElement targetBox = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(sourceBox, targetBox).release().perform();
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[.='Dropped!']")).getText());

    }
}
