package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.IOException;

public class C01_JSExecutor_Scroll extends TestBase {/*
JS executor, js kodlarini java framework'unde kullanabilmek icin olusturulan bir API'dir. Bu API selenium'da gelir.  */


    @Test
    public void scrollIntoViewTest() throws IOException {
//        Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

//        We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran goruntusunu al
//        1. Elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

//        2. JS executor objesi olustur
        JavascriptExecutor js = (JavascriptExecutor)driver;

//        3. Yapmak istedigin islemi js.executeScript metodu ile yap
//        scrollIntoView(true); metotu belirli bir elemente scroll yapmak icin kullanilir
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer); //arguments[0]-> ilk parametredeki element(weoffer)
        waitFor(3);

//        Sayfa goruntusunu al
        takeScreenShotOfPage();

//        Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrollIntoViewJS(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();

//        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement whyUS = driver.findElement(By.xpath("//h3[.='WHY US?']"));
        scrollIntoViewJS(whyUS);
        waitFor(3);
        takeScreenShotOfPage();

    }

}
