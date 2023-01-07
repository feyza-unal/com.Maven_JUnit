package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR); //--> /Users/feyzaunal/IdeaProjects/com.Maven_JUnit

        String userHome = System.getProperty("user.home");
        System.out.println(userHome); //--> /Users/feyzaunal


        String filePath = userHome+"/Desktop/logo.jpeg"; // bu sekilde olusturdugumuzda baskalarida
                                                        // kodu calistirdiginda hata vermez (dosya masaustunde olmali)
        System.out.println(filePath);

        boolean isExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);
    }
}
