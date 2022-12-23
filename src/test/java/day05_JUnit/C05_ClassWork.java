package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {

//      Verilen web sayfasına gidin https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

//      Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cb1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

//      Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!cb1.isSelected()) { //secili degilse
            cb1.click();
        }
        Thread.sleep(3000);

//      Checkbox2 seçiliyse onay kutusunu tıklayın
        if (cb2.isSelected()) {
            cb2.click();
        }

    }
}
