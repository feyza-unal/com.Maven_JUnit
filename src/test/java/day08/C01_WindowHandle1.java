package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.HashSet;
import java.util.Set;

public class C01_WindowHandle1 extends TestBase {
    @Test
    public void windowHandleTest() throws InterruptedException {
//      https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//      Ilk sayfanin IDsini alalim
        String window1Handle = driver.getWindowHandle();

//      Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String text = driver.findElement(By.xpath("//h3")).getText();
        String expectedText= "Opening a new window";
        Assert.assertEquals(text,expectedText);

//      Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title = driver.getTitle();
        String expectedTitle= "The Internet";
        Assert.assertEquals(title,expectedTitle);

//      Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

//      Bu noktada 2 pencere acik ve ikincisine gecis yapmak istiyorum
//      Bunun icin driver.getWindowHandles() ile tum pencerelerin IDlerini alalim
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String w : allWindowHandles){
//           eger listedeki id window1'e esit degilse, otomatik olarak bir sonrakine esittir

             if (!w.equals(window1Handle)){
                 driver.switchTo().window(w); //burdaki eachHandle window2 handle'ina esittir
             }
        }
//      Bu noktada driver 2. pencerede
//      Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());

//      Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());
        String window2Handle = driver.getWindowHandle();

//      Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(window1Handle); //window1 handle'a donuyoruz
        Assert.assertEquals("The Internet",driver.getTitle());

//      2. pencereye tekrar gecelim
        Thread.sleep(3000);
        driver.switchTo().window(window2Handle);

//      1. pencereye tekrar gecelim
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
    }
}
