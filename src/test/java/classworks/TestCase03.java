package classworks;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class TestCase03 extends TestBase {
    @Test
    public void test01() {
//      Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get(" https://www.amazon.com/");

//      Sayfa basligini(title) yazdirin
        String title = driver.getTitle();
        System.out.println(title);

//      Sayfa basliginin "Amazon" icerdigini test edin
        Assert.assertTrue(title.contains("Amazon"));

//      Sayfa adresini(url) yazdirin
        String url = driver.getCurrentUrl();
        System.out.println(url);

//      Sayfa url'inin "amazon" icerdigini test edin.
        Assert.assertTrue(url.contains("amazon.com"));

//      Sayfa handle degerini yazdirin
        String winHandle = driver.getWindowHandle();
        System.out.println(winHandle);

//      Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        Assert.assertTrue(driver.getPageSource().contains("Gateway"));

//      Sayfayi kapatin.
        driver.close();
    }
}
