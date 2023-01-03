package classworks;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class TestCase07 extends TestBase {
    @Test
    public void test01() {
//      facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
        driver.get("https://www.facebook.com");

//      sayfa basliginin "facebook" old. dogrulayin (verify), degilse dogru basligi yazdirin.
        String title = driver.getTitle();
        String expected = "facebook";
        if (title.equals(expected)) {
            System.out.println("PASSED");
        }else System.out.println(title);

//      Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'i yazdirin.
        String url = driver.getCurrentUrl();
        String expectedUrl = "facebook";
        if (url.equals(expectedUrl)) {
            System.out.println("PASSED");
        }else System.out.println(url);

//      https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

//      Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
        Assert.assertTrue(driver.getTitle().contains("Walmart.com"));

//      Tekrar "facebook" sayfasina donun
        driver.navigate().back();

//      Sayfayi yenileyin
        driver.navigate().refresh();

//      Browser'i kapatin
        driver.close();
    }
}
