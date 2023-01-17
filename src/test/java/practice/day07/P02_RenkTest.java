package practice.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P02_RenkTest extends TestBase {
    @Test
    public void test01() {
//     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

//     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement yesil = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement mavi = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        actions.
                dragAndDropBy(yesil,-175,0).
                dragAndDropBy(mavi,-80,0).
                perform();//kirmizi
        waitFor(4);

        actions.
                dragAndDropBy(yesil,301,0).
                perform(); //sari
        waitFor(4);

//     -Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        //getCssValue("background-color");
        //Assert.assertTrue(sari.isDisplayed());
        assert sari.isDisplayed();

    }

}
