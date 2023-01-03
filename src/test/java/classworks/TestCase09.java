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
        List<WebElement> iframeList = driver.findElements(By.xpath("//iframe"));
        int iframeSayisi = iframeList.size();
        System.out.println(iframeSayisi);

//      ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


//      ilk iframe'den çıkıp ana sayfaya dönünüz
        //driver.switchTo().defaultContent(); yada
        driver.navigate().refresh();

//      ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }
}
