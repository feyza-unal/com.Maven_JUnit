package practice.day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01_SekilCizme extends TestBase {
    @Test
    public void test01() {
//       - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//       - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(canvas).clickAndHold();

        for (int i = 0; i<10; i++){
            actions.moveByOffset(5,5);
        }for (int i = 0; i<10; i++){
            actions.moveByOffset(5,0);
        }for (int i = 0; i<10; i++){
            actions.moveByOffset(0,5);
        }
        actions.release().build().perform();

        waitFor(2);
//       - Çizimden sonra clear butonuna basalım
        driver.findElement(By.xpath("//*[@class='button clear']")).click();


/* daire
 actions.moveByOffset(660,345).build().perform();
        int y = 10;
        actions.clickAndHold().build().perform();
        for (int i=1; i<11; i++){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=11; i>0; i--){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=0; i>-11; i--){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
        for (int i=-11; i<3; i++){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
 */
    }
}
