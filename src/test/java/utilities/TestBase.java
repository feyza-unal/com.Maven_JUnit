package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase { //abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyoruz
// amacimiz bu sinifi extend etmek ve icindeki methodlari kullanmak

//  driver objesini olustur. --> driver public yada protected olmali (child classlarda gorulebilmeli)
    protected static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

//------------------window handle pencere gecisi icin methodlar-----------------
//    MULTIPLE WINDOW
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }
//----------------------------------------------------------------
//     windowNumber sıfır (0)'dan başlıyor.
//     index numarasini parametre olarak alir
//     ve o indexli pencerece gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
//yazdigimiz koda gore ilk pencerenin indexi 0, yeni acilan 2. pencrenin indexi 1 dir

//-------------------Thread.sleep() icin method----------------------
 /*   HARD WAIT:
     @param : second
 */
public static void waitFor(int seconds){
    try {
        Thread.sleep(seconds*1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
// --> koda waitFor(saniye) yazmam yeterli
//----------------------------------------------------------------
}
