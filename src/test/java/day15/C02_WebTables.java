package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void table1Print() {

//      http://the-internet.herokuapp.com/tables  Task 1 : Table1’i print edin
        driver.get("http://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("Table1 verileri :");
        System.out.println(table1);

        //2.yol
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
//        tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMDA
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }
    }
        @Test
        public void row3Print() {
//      Task 2 : 3. Row’ datalarını print edin
            driver.get("https://the-internet.herokuapp.com/tables");
            List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
            row3Elements.forEach(veri-> System.out.println(veri.getText()));

    }

        @Test
        public void sonSatirTest() {
//      Task 3 : Son row daki dataları print edin
            driver.get("http://the-internet.herokuapp.com/tables");
            List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
            //last son satira gider. last()-1 sondan 1 onceki diye de kullanabiliriz
            sonSatirVerileri.forEach(veri-> System.out.println(veri.getText()));

        }

    @Test
    public void sutun5Test() {
//      Task 4 : 5. Column datalarini print edin
        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5Verileri = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5Verileri.forEach(veri-> System.out.println(veri.getText()));

    }



//      Task 5 : Iki parametreli bir Java metot oluşturalım: printData


//      Parameter 1 = row numarasi


//      Parameter 2 = column numarasi


//      printData(2,3);  => 2nd row, 3rd column daki datayı print etsin



}
