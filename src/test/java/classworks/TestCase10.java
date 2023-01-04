package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase10 extends TestBase {
    @Test
    public void test01() {
//      https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/ ");

//      Add Element butonuna basin
        driver.findElement(By.xpath("//*[.='Add Element']")).click();

//      Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete']"));
        Assert.assertTrue(deleteButton.isDisplayed());

//      Delete tusuna basin
        deleteButton.click();

//      "Add/Remove Elements" yazisinin gorunur oldugunu test edin
        String expectedText = "Add/Remove Elements";
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
