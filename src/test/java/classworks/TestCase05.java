package classworks;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

public class TestCase05 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//      Sayfanin konumunu ve boyutlarini yazdirin
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);

//      Sayfayi simge durumuna getirin.Simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();

//      Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        Point position2 = driver.manage().window().getPosition();
        System.out.println("position maximize = " + position2);

        Dimension size2 = driver.manage().window().getSize();
        System.out.println("size maximize = " + size2);

//      Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

//      Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        Point position3 = driver.manage().window().getPosition();
        System.out.println("position fullscreen = " + position3);

        Dimension size3 = driver.manage().window().getSize();
        System.out.println("size fullscreen = " + size3);

//      Sayfayi kapatin
        driver.close();

    }
}
