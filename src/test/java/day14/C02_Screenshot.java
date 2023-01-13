package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class C02_Screenshot extends TestBase {
    @Test
    public void screenshotOfSpecificElements() throws IOException {
//      Techpro education a git
        driver.get("https://techproeducation.com/");

//      Sosyal medya elemanlarını goruntusunu al

        //1. screenshot al
        WebElement socialMediaIcons = driver.findElement(By.xpath("(//*[@class='elementor-social-icons-wrapper elementor-grid'])[1]"));
        File image = socialMediaIcons.getScreenshotAs(OutputType.FILE);

        //2. kaydet
        String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

// REUSABLE method ile logoyu al
        WebElement logo = driver.findElement(By.xpath("//img[@class='attachment-large size-large lazyloaded']"));
        takeScreenshotOfElement(logo);
    }
}
