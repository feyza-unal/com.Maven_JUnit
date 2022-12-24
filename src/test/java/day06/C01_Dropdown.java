package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;
    //    Eger test sinifinda birden fazla method olusturulmussa, @Before kullanir
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest() {
    //Dogun yilini, ayini, ve gununu su sekilde secin: 2000, January, 10

// 1. LOCATE  dropdown element
// 2. Select objesi olustur
// 3. Select object'i kullanarak 3 farkli sekilde secim yapabilirim

        // yil secimi
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select yearDropDown = new Select(year);
        yearDropDown.selectByIndex(22); // secenek sirasi 0dan baslar. 2000 yili 23. sirada demek

        // Ay secimi
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByValue("0");

        //Gun secimi
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByVisibleText("10");
    }
    @Test
    public void printAllTest(){
        //tum eyalet isimlerini yazdiralim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();
//        for (WebElement w : stateList) {
//            System.out.println(w.getText());
//        }
        stateList.stream().forEach(t-> System.out.println(t.getText())); // -->//lambda hali
    }
    @Test
    public void getSelectedOptionsTest() {
//       State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
//        WebElement varsayilanElement = stateDropdown.getFirstSelectedOption();
//        String varsayilanElementText = varsayilanElement.getText();
        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);
    }
    @After
    public void tearDown(){
        driver.close();
    }

/*
        1. What is dropdown? dropdown nedir ?
        Dropdown liste olusturmak icin kullanilir

        2. How to handle dropdown elements? Dropdown nasil automate edilir?
        -dropdown'i locate ederim
        -select obj olustururum
        -select objesi ile istedigim secenegi secerim

        Not: select obj olusturma nedenim, dropdownlarin Select classi ile olusturulmasi

        3. Tum dropdown seceneklerini nasil print ederiz?
        -tum dropdown elementlerini getOptions() methodu ile listeye koyariz
        -sonra listeyi loop ile yazdirabiliriz

        4. Bir secenegin secili oldugunu otomate etmek icin napilir?
        Ornek: Gun olarak 10'u sectik ama ya secilmediyse?
        getFirstSelectedOption() secili olan secenegi return eder


 */

}
