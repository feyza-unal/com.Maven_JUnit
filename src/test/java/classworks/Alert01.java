package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Alert01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("https://demo.automationtesting.in/Alerts.html");

//      click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();
        Thread.sleep(3000);

//      accept Alert(I am an alert box!) and print alert on console
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();

//      click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

//      cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

//       click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

//      and then sendKey "your name"
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("feyza");
        driver.switchTo().alert().accept();

//      finally print on console this message "Hello feyza How are you today"
        Thread.sleep(2000);
        String actualMessage = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        Assert.assertTrue(actualMessage.contains("feyza"));


    }
}
