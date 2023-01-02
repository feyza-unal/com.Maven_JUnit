package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

//      new butonuna basar
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();
        Thread.sleep(3000);

//      firstname kutusuna "<firstName>" bilgileri girer
//      lastname kutusuna "<lastName>" bilgileri girer
//      position kutusuna "<position>" bilgileri girer
//      office kutusuna "<office>" bilgileri girer
//      extension kutusuna "<extension>" bilgileri girer
//      startdate kutusuna "<startDate>" bilgileri girer
//      salary kutusuna "<salary>" bilgileri girer
//      Create tusuna basar
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).
                sendKeys("feyza",Keys.TAB,
                        "unal",Keys.TAB,
                        "QA",Keys.TAB,
                        "Tester",Keys.TAB,
                        "-",Keys.TAB,
                        "2022-11-01",Keys.TAB,
                        "8000");
        driver.findElement(By.xpath("//*[@class='btn']")).click();

        Thread.sleep(3000);

//      Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//*[text()='Search:']")).sendKeys("feyza unal",Keys.ENTER);
        String actualText = driver.findElement(By.xpath("//*[@class='sorting_1']")).getText();
        Assert.assertEquals("feyza unal",actualText);

        Thread.sleep(3000);

//      Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[@class='sorting_1']")).click();
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();

        Thread.sleep(3000);

//      Kullanıcinin silindiğini doğrular.
        driver.findElement(By.xpath("//*[text()='Search:']")).sendKeys("feyza",Keys.ENTER);
        String actualText2 = driver.findElement(By.xpath("//*[@class='dataTables_empty']")).getText();
        String expectedText2 = "No matching records found";
        Assert.assertEquals(expectedText2, actualText2);

    }
}
