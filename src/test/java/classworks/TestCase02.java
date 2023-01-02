package classworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TestCase02 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

//      ~ click on Phones & PDAs
        driver.findElement(By.linkText("Phones & PDAs")).click();

//      ~ get the brandName of phones
        List<WebElement> brandList = driver.findElements(By.xpath("//h4"));
        List<String> brandNamesForCheck = new ArrayList<>(); //son soru icin
        for (int i=0; i<brandList.size(); i++) {
            brandNamesForCheck.add(brandList.get(i).getText()); // list'e eleman eklemek icin
            System.out.println(brandList.get(i).getText()); //markalari yazdir
        }

        Thread.sleep(3000);

//      ~ click on add to button for all elements
        List<WebElement> addAll = driver.findElements(By.xpath("//*[.='Add to Cart']"));
        for (int i=0; i<addAll.size(); i++) {
            addAll.get(i).click();
        }

        Thread.sleep(3000);

//      ~ click on black total added cart button
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();

        System.out.println("**********");

//      ~ get the names of list from the cart
        List<WebElement> namesInCart = driver.findElements(By.xpath("//*[@class='text-left']"));
        for (int i=0; i<namesInCart.size(); i++) {
            System.out.println(namesInCart.get(i).getText());
        }

        Thread.sleep(3000);

//      ~ compare the names from displaying list and cart list
        Assert.assertTrue(namesInCart.containsAll(brandNamesForCheck));
    }
}
