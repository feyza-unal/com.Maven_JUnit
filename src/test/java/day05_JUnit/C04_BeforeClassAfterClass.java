package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarinin hepsini
    ayni anda calistirip en son @AfterClass'i calistiririz

    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After kullanir

     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Butun testlerden once calisti");
    }

    @AfterClass
    public static void  tearDown() {
        System.out.println("Butun testlerden sonra calisti");

    }

    @Before
    public void setUp2(){
        System.out.println("Her testten once calisir");
    }

    @After
    public void tearDown2() {
        System.out.println("Her testten sonra calisir");

    }

    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }
}

/*

Butun testlerden once calisti
Her testten once calisir
Ilk Test
Her testten sonra calisir
Her testten once calisir
Ikinci Test
Her testten sonra calisir
Butun testlerden sonra calisti

 */