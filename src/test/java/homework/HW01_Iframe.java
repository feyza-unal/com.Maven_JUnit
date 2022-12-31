package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class HW01_Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {

//https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        int iframeSize = iframeList.size();
        System.out.println("iframe sayisi : " + iframeSize);

//Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String baslik = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(baslik.contains("Editor"));

//Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        text.clear();

//Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        Thread.sleep(3000);
        text.sendKeys("iframein icindeyim");

//Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String footer = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertTrue(footer.contains("Elemental Selenium"));

    }
}
