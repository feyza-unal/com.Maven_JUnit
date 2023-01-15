package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws IOException {
//       WORKBOOK(EXCEL DOSYASI) > WORKSHEET/SHEER(SAYFA) > ROW(SATIR) > CELL(VERI HUCRESI)
        String path = "./src/test/java/resources/Capitals.xlsx";

//       DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//      EXCEL DOSYASINI/WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//       SAYFAYI/SHEET AC
        //Sheet sheet1 = workbook.getSheetAt(0);  // index 0dan baslar. ilk sayfayi ac
        Sheet sheet1 = workbook.getSheet("Sheet1");  //direk gitmek istedigimiz sayfayi ac

//      ILK SATIRA/ROW GIT
        Row row1 = sheet1.getRow(0); //ilk satira git

//       ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0); // ilk hicredeki datayi ver

//       VERIYI YAZDIR
        System.out.println(cell1);

//        1. SATIR 2. SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

//      3. SATIR 1. SUTUNU YAZDIR VE "France" OLDUGUNU TEST ET
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

//        EXCELDEKI TOPLAM SATIR SAYISI
        int toplamSatirSayisi = sheet1.getLastRowNum()+1; //son satir numarasi + index 0dan basladigi icin 1 ekliyoruz
        System.out.println(toplamSatirSayisi);

//        KULLANILAN TOPLAM SATIR SAYISI
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi); //1den basliyor. Dolu hucreleri sayar

//        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}
//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi = 1; satirSayisi<kullanilanToplamSatirSayisi; satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);

    }
}
