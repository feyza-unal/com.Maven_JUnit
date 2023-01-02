package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle_03 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

//      Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();

//      ""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String expectedText = "Please select an item from left to start practice.";
        String actualText = driver.
                findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).
                getText();
        Assert.assertEquals(expectedText,actualText);

//      Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();
        String window1Handle = driver.getWindowHandle();

//      New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed());

//      New Tab butonuna click yap
        Thread.sleep(3000);
        driver.findElement(By.id("[id='tabButton']")).click();

//      -->yeni tab acildi
        Set<String> allWindowHandles = driver.getWindowHandles();
//      -->diger tab'a gec
        for (String w : allWindowHandles){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
            }
        }

//      Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String actualText2 = driver.findElement(By.id("[id='sampleHeading']")).getText();
        String expectedText2 = "This is a sample page";
        Assert.assertEquals(expectedText2, actualText2);

//      İlk Tab'a geri dön
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);

//      New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("[id='tabButton']")).isDisplayed());

    }
}
