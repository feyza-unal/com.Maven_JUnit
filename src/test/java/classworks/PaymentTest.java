package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class PaymentTest extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com ");
        driver.navigate().refresh();

//      Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();

//      Login alanine  "username" yazdirin
//      Password alanine "password" yazdirin
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username", Keys.TAB,
                "password",Keys.TAB,Keys.SPACE);

//      Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        Thread.sleep(3000);
        driver.navigate().back();

//      Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("[id='onlineBankingMenu']")).click();
        driver.findElement(By.cssSelector("[id='pay_bills_link']")).click();

//      amount kismina yatirmak istediginiz herhangi bir miktari yazin
//      tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("[id='sp_amount']")).sendKeys("80",Keys.TAB,"2020-09-10");
        Thread.sleep(3000);

//      Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("[id='pay_saved_payees']")).click();

//      "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        String actualText = driver.findElement(By.cssSelector("[id='alert_content']")).getText();
        Assert.assertEquals("The payment was successfully submitted.",actualText);
        Thread.sleep(3000);
    }
}
