package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_HoverOver extends TestBase {
    @Test
    public void hoverOver() {
//      Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//      Sag ust bolumde bulunan “Account & Lists” menüsüne git (mouse over-uzerinde bekle)
        Actions actions = new Actions(driver);
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
        waitFor(3);

//      “Account” secenegine tikla
        driver.findElement(By.linkText("Account")).click();

//      Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }
}
