package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle_02 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      url'ye git: http://demo.guru99.com/popup.php
        driver.get("https://demo.guru99.com/popup.php");

//       ilk pencereyi al
        String window1Handle = driver.getWindowHandle();

//       "Click Here" butonuna tıklayın
        driver.findElement(By.linkText("Click Here")).click();

//       setteki tüm pencereyi al
        Set<String> allWindowHandles = driver.getWindowHandles();

//       diğer pencereye geç
        for (String w : allWindowHandles){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
            }
        }

//       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("someone@gmail.com");

//       Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@value='Submit']")).click();

//       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String expected = "This access is valid only for 20 days.";
        String actual = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expected,actual);

//       Tekrar ilk pencereye geç
        driver.switchTo().window(window1Handle);
        Thread.sleep(3000);

//       İlk pencerede olduğunu doğrula
        Assert.assertEquals(window1Handle,driver.getWindowHandle());
        // url'de olabilir

    }
}
