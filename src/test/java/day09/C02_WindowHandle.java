package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {
    @Test
    public void newWindowHandleTest() { //selenium 4

//      1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://techproeducation.com/");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        String techproHandle = driver.getWindowHandle();

//      2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(2);
        driver.switchTo().newWindow(WindowType.WINDOW); //1-> yeni pencere olusturur. 2-> oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//      3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(2);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

//      Driver'i ilk sayfaya gotur
        waitFor(2);
        driver.switchTo().window(techproHandle);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));


        waitFor(2);
    }
}
