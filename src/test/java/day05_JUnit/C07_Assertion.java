package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

    //      Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//          ○ title Test  => Sayfa başlığının “Amazon” oldugunu testedin
//          ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
//          ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//          ○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin
    @Test
    public void test01() {
        String actualtitle = driver.getTitle();
        String expectedtitle = "Amazon";
        Assert.assertTrue(actualtitle.contains(expectedtitle));
    }

    @Test
    public void test02() {
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }

    @Test
    public void test03() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}

/*
Eger test methodumuzda hicbir test yoksa, test calistiktan sonra hicbir problemle karsilasilmadigini raporlamak icin
"test passed" yazisi cikar

Eger testleri if ile yaparsak test failed olsa bile kodlar problemsiz calistigi icin kodun calismasi bittiginde
ekranin sol alt kisminda "test passed" yazacaktir

 */