package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }


//      REUSABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim
    public void selectFromDropdown(WebElement dropdown, String secenek) {
//        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
//        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
//        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));

//Gonderilen dropdown element'in tum optionslari alinir
        List<WebElement> options = dropdown.findElements(By.tagName("option")); //tum option tagli elementleri aliyorum

        for (WebElement w : options) {
            if (w.getText().equals(secenek)){
                w.click();
                break;
            }
        }
    }

}