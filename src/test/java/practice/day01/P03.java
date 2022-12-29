package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//      Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

//      Click on  Calculate under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

//      Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("15", Keys.ENTER);

//      Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("10", Keys.ENTER);

//      Click on Calculate
        driver.findElement(By.id("calculate")).click();

//      Print the result
        WebElement result = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println(result.getText());

// 2.yol
//        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        driver.findElement(By.id("calculatetest")).click();
//        WebElement firstName = driver.findElement(By.id("number1"));
//        firstName.sendKeys("30", Keys.TAB,Keys.TAB,"30",Keys.ENTER);
//        WebElement sonuc = driver.findElement(By.xpath("//*[@ID='answer']"));
//        System.out.println("sonuc.getText() = " + sonuc.getText());

//      close driver
        driver.close();

    }
}
