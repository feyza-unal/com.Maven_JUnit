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

public class C06_ClassWork {
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
//      https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

//      “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

//      “radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("(//*[@class='_8esa'])[1]"));
        WebElement maleButton = driver.findElement(By.xpath("(//*[@class='_8esa'])[2]"));
        WebElement customButton = driver.findElement(By.xpath("(//*[@class='_8esa'])[3]"));

//      Secili degilse cinsiyet butonundan size uygun olani secin
        if (!femaleButton.isSelected() && !maleButton.isSelected()) {
            femaleButton.click();
        }
        Thread.sleep(3000);
        maleButton.click();
        Thread.sleep(3000);
        customButton.click();


    }

}
