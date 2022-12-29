package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//      go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

//      fill the firstname
//      fill the lastname
//      check the gender
//      check the experience
//      fill the date
//      choose your profession -> Automation Tester
//      choose your tool -> Selenium Webdriver
//      choose your continent -> Antartica
//      choose your command  -> Browser Commands
//      click submit button

        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys("Erol",
                Keys.TAB,"Evren",
                Keys.TAB,Keys.ARROW_RIGHT, //--> gender(female)
                Keys.TAB,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT, //--> experience(4)
                Keys.TAB,"12/12/2022", //-->date
                Keys.TAB,Keys.TAB,Keys.SPACE, //--> profession(automation tester)
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE, //-->Tool(Selenium)
                Keys.TAB,"Antartica", //-->continent(Antartica)
                Keys.TAB,Keys.ARROW_DOWN, //-->command (Browser)
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER   //-->submit button
        );  // --> taba basakarak bir sonrakine gectik


    }
}
