package classworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IFrame01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

//      ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

//      ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//*[@class='emoji']"));
        for (WebElement w : emojiList) {
            w.click();
        }

        Thread.sleep(3000);

//      ana iframe'e geri dön
        driver.switchTo().defaultContent();

//      formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//*[@id='text']")).
                sendKeys("emoji", Keys.TAB,
                        "happy",Keys.TAB,
                        "bear",Keys.TAB,
                        "coconut",Keys.TAB,
                        "ice skate",Keys.TAB,
                        "city",Keys.TAB,
                        "candle",Keys.TAB,
                        "heart",Keys.TAB,
                        "turkiye");

//      uygula butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
        Thread.sleep(3000);

    }
}
