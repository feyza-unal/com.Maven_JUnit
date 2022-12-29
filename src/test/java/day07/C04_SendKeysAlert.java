package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_SendKeysAlert extends TestBase {
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//      3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

//      uyarıdaki metin kutusuna isminizi yazin,
        Thread.sleep(5000);
        driver.switchTo().alert().sendKeys("feyza");

//      OK butonuna tıklayın ve
        driver.switchTo().alert().accept();

//      result mesajında isminizin görüntülendiğini doğrulayın.
        Thread.sleep(5000);
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(result.contains("feyza"));
    }



}
