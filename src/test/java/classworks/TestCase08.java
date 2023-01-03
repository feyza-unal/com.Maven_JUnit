package classworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;
import java.util.List;

public class TestCase08 extends TestBase {
    @Test
    public void test01() {
//      web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//       Search(ara) "city bike"
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("city bike", Keys.ENTER);

//       Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        String text = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String result = text.split(" ")[2];
        System.out.println(result);//113

//       Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

    }
}
