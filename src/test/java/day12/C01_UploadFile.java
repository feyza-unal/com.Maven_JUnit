package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {
    @Test
    public void fileUploadTest() {
//      https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

//      Choose File butonuna basalim. Yuklemek istediginiz dosyayi secelim.
        driver.findElement(By.id("file-upload")).
                sendKeys(System.getProperty("user.home")+"/Desktop/logo.jpeg"); //-> /Users/feyzaunal/Desktop/logo.jpeg

//      Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//      “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertEquals("File Uploaded!",driver.findElement(By.xpath("//h3")).getText());

        waitFor(2);
    }
}
