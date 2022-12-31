package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHandle_01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

//● Sayfa’nin window handle degerini String bir degiskene atayin
        String window1Handle = driver.getWindowHandle();

//● Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://techproeducation.com");
        Thread.sleep(3000);

// ● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));

//● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).navigate().to("https:www.walmart.com");
        Thread.sleep(3000);

//● Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

//● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(window1Handle);
        Thread.sleep(3000);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

    }
}
