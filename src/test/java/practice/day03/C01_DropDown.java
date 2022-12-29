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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
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
    public void test01() throws InterruptedException {

//      https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

//      Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        String op1 = select.getFirstSelectedOption().getText();
        System.out.println(op1);

//      Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        Thread.sleep(3000);
        select.selectByValue("2");
        String op2 = select.getFirstSelectedOption().getText();
        System.out.println(op2);

//      Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");
        String op1visibleText = select.getFirstSelectedOption().getText();
        System.out.println(op1visibleText);

//      Tüm option'ları yazdırın
        List<WebElement> allOp =  select.getOptions();
        int sayac = 1;
        for (WebElement w : allOp) {
            System.out.println(sayac+ ". Option "+ w.getText());
            sayac++;
        }
//      dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected = 3;
        int actual = allOp.size();
        Assert.assertEquals(actual,expected);

    }
}
