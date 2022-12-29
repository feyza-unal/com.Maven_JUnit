package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    @Test
    public void acceptAlertTest() throws InterruptedException {
//      https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//      1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

//      uyarıdaki OK butonuna tıklayın
        Thread.sleep(5000);
        driver.
                switchTo().
                alert().
                accept(); //kabul etmek demek icin accept dedik

//      ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        Thread.sleep(5000);
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String resultText = "You successfully clicked an alert";
        Assert.assertEquals(result,resultText);

    }



    /*
Alertleri nasil automate ederiz? How to handle alerts in selenium?
-alertler javascript ile olusur.Inspect edilemezler. oncelikle alerte switch etmemiz gerekir

 */
}
