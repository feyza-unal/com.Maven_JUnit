package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
}
