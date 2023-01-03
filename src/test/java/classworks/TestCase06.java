package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

public class TestCase06 extends TestBase {
    @Test
    public void test01() {
//      Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("ttps://www.amazon.com/");

//      Sayfanin konumunu ve boyutlarini yazdirin
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);

//      Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));

//      Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Dimension actualNewSize = driver.manage().window().getSize();
        if (actualNewSize.getWidth()==600 && actualNewSize.getHeight()==600){
            System.out.println("Size passed the test");
        }else System.out.println("Size failed the test");

        Point actualYeniKonum = driver.manage().window().getPosition();
        if(actualYeniKonum.getX()==50 && actualYeniKonum.getY()==50){
            System.out.println("Konum TESTİ PASSED");
        }else System.out.println("Konum TESTİ FAILED");

//      Sayfayi kapatin
        driver.close();
    }
}
