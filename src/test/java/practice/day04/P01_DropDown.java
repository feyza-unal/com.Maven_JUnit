package practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P01_DropDown extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

//      Dropdown menuyu yazdiralim
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.forEach(t-> System.out.println(t.getText()));

//2.yol
//        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
//        Select select = new Select(dropdown);
//        for (WebElement w:select.getOptions()) {
//            System.out.println(w.getText());
//        }

//      Dropdown menuden baby seçelim
//      arama bölumunden milk aratalım
        WebElement dropdownmenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        dropdownmenu.sendKeys("Baby",Keys.TAB,"Milk",Keys.ENTER);

    }
}
