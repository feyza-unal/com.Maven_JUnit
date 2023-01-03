package classworks;

import org.junit.Test;
import utilities.TestBase;

public class TestCase04 extends TestBase {
    @Test
    public void test01() {
//      Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("ttps://www.youtube.com/");

//      Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

//      Tekrar YouTube'sayfasina donelim
        driver.navigate().back();

//      Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

//      Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

//      Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();

    }
}
