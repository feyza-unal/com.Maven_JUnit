package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
//        Thread.sleep(10000);
//        driver.close();
    }

    @Test
    public void test01() {

//      https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

//      dropdown'dan "Baby" secenegini secin
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        select.selectByIndex(3); // --> baby

//      sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());

//      dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> allOptions = select.getOptions(); // tum opsiyonlari saydirmaliyiz
        int actualOptionsNumber = allOptions.size(); //28
        int expectedOptionsNumber = 28;

        Assert.assertEquals(expectedOptionsNumber,actualOptionsNumber);
    }

}
