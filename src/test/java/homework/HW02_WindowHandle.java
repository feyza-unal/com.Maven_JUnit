package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class HW02_WindowHandle extends TestBase {
    @Test
    public void test01() {
//https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

//Title'in "Windows" oldugunu test edin
        String title = driver.getTitle();
        Assert.assertEquals(title,"Windows");
        String window1Handle = driver.getWindowHandle();

//Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();

//Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){
                driver.switchTo().window(eachHandle); //burdaki eachHandle window2 handle'ina esittir
            }
        }
        // artik 2. penceredeyiz
        Assert.assertEquals("New Window",driver.getTitle());

    }
}
