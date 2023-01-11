package practice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P04_Actions extends TestBase {
    @Test
    public void test01() {
//     http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

//     Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        Actions actions = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("//*[text()='Fleet']"));
        actions.scrollToElement(fleet).perform();
        fleet.click();
//--> Bazi sitelerde elementi gorene kadar kaydirmak gerekiyor

//     Sayfa başlığının Fleet içerdiğini test edelim
       switchToWindow(1);//acilan sekmeye gectik
       Assert.assertTrue(driver.getTitle().contains("Fleet"));
    }
}
