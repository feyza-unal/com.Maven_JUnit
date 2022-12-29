package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {
    WebDriver driver;
    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown()  {
        driver.close();
    }

    @Test
    public void name() throws InterruptedException {

//      ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");

//      electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[@_sp='p2481888.m1379.l3250'])[1]")).click();

//      Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
//      Her sayfanın sayfa başlığını yazdıralım
        for (int i = 0; i < 24; i++){
            List<WebElement> products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            products.get(i).click();
            Thread.sleep(2000);
            System.out.println((i+1)+". baslik : "+driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }

//
    }
}
