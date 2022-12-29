package practice.day03;

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

public class C02_Checkbox {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {

//      https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

//      checkbox elementlerini locate edin
        WebElement cb1 = driver.findElement(By.xpath("//*[@id='vfb-6-0']"));
        WebElement cb2 = driver.findElement(By.xpath("//*[@id='vfb-6-1']"));
        WebElement cb3 = driver.findElement(By.xpath("//*[@id='vfb-6-2']"));

//      checkbox1 ve checkbox3  secili degil ise secin
        if (!cb1.isSelected()){
            cb1.click();
        }
        if (!cb3.isSelected()){
            cb3.click();
        }

//      checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(cb1.isSelected());
        Assert.assertTrue(cb3.isSelected());

//      checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(cb2.isSelected());

    }
}
