package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;

public class C01_DropDownMenu {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void test01() {
//      https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

//          dropdown 3 adimda handle edilir
//          1- locate edilmeli
//          2- select objesi olusturulmali
//          3- opsiyon secilir

//      dropdown'dan "Books" secenegini secin
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");
//      select.selectByIndex(12);
//      select.selectByValue("search-alias=stripbooks");

//      arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

//      arama sonuclarinin Java icerdigini test edin
        WebElement resultsElemet = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String results = resultsElemet.getText();
        Assert.assertTrue(results.contains("Java"));

    }
}




