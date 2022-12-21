package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_FirstTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//      https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

//      arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

//      "Samsung headphones" ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);
//      Keys.ENTER yerine searchBox.submit(); diyebiliriz

//      Bulunan sonuc sayisini yazdiralim
        WebElement searchResult = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
//     -->111 tane degerden ilkini almak icin index girdik

        System.out.println("Arama sonucu : "+ searchResult.getText());

//      Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

//      Sayfadaki tum basliklari yazdiralim
        List<WebElement> titles = driver.findElements(By.xpath("//h1"));
//        for (WebElement w : titles) {
//            System.out.println(w.getText()) ;
//        }
        titles.forEach(t-> System.out.println(t.getText()));

//      Sayfayi kapatalim
        driver.close();
    }
}
