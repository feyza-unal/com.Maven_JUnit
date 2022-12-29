package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {/*

UTILITIES:
->tekrar tekrar kullanacagimiz classlari koydugumuz pkaetin adidir.
    * Test Base
    * Driver
    * ExcelUtil
    * Configuration
-> Utilities paketinde test case yazilmaz (@Test)
-> Sadece tekrar kullanilabilecek destek siniflari(support class) olusturulur.
-> Bu support classlar test caselerin yazilmasini hizlandirir

 */

    @Test
    public void test01() {
//      techproeducation ana sayfasina git ve title'in "Bootcamps" kelimesini icerdigini test edin
        driver.get("https://techproeducation.com/");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Bootcamps"));
    }
}
