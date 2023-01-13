package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {/*
Seleniumda tum ekran goruntusu nasil alinir ?
# getScreenshotAs methodu ile
# getScreenshotAs methodu seleniumdaki TakesScreenshot api'indan gelir. */

    @Test
    public void takeScreenShot() throws IOException {
//      Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com/");

//      -“QA” aramasi yap
        driver.findElement(By.xpath("//*[@class='elementor-search-form__input']")).sendKeys("QA"+ Keys.ENTER);

//      1. Ekran goruntusunu getScreenshotAs metotu ile alip File olarak olusturalim
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//      2. Almis oldugum ekran goruntusunu belirledigim bir PATHe kaydet (.dir -> directory=dosya yolu)
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef = new File(path);
//NOTE:screenshot ismine tarihi ekleyerek (date obj ile) dinamik yaptik
//      3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

//      Alternatif olarak tum bu adimlari tek seferde degisken kullanmadan yapabilirim
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),                //goruntu
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));  //path

//      Acilan sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue("Search Results for: QA".contains(text));

//      REUSABLE method yardimiyla screenshot alalim
        takeScreenShotOfPage();
    }
}
