package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() throws InterruptedException {// test case'in baska bi cozumu (reusable method ile)

//      https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//      Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        String expectedText= "Opening a new window";
        Assert.assertEquals(expectedText,actualtext);

//      Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualtitle = driver.getTitle();
        String expectedTitle= "The Internet";
        Assert.assertEquals(expectedTitle,actualtitle);

        String window1Handle = driver.getWindowHandle();

//      Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(2);

        //2. pencereye gecis
        switchToWindow(1); //index'li olani sectik
//reusable method da yazdigimiz koda gore ilk pencerenin indexi 0, yeni acilan 2. pencrenin indexi 1 dir

//      Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());


    }
}

