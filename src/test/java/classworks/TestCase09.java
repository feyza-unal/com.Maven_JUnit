package classworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase09 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

//      sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.tagName("<iframe"));
        int iframeSayisi = iframeList.size();
        System.out.println(iframeSayisi);

//      ilk iframe'deki (Youtube) play butonuna tıklayınız.
//        driver.switchTo().frame(2);
//        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
//        Thread.sleep(3000);

//      ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

//      ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
//        driver.switchTo().frame(By
//        driver.findElement(By.xpath("(//*[@class='vsc-initialized'])[2]")).click();
//        Thread.sleep(3000);
    }
}
