package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    @Test
    public void dismissAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//      2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

//      uyarıdaki Cancel butonuna tıklayın ve
        Thread.sleep(5000);
        driver.
                switchTo().
                alert().
                dismiss();

//      result mesajının “You clicked: Cancel” oldugunu test edin.
        Thread.sleep(5000);
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String resultText = "You clicked: Cancel";
        Assert.assertEquals(result,resultText);
    }

}
