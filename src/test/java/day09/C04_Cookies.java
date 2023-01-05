package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest() {

//      Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);

//      toplam cookie sayisini bul
        Set<Cookie> allCookies =  driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada "+cookieSayisi+ " adet cookie var");

//      Tum cookie'leri yazdiralim
        // lambda -> allCookies.stream().forEach(t -> System.out.println(t.getName()));
        for (Cookie w : allCookies){
            System.out.println("COOKIE : " + w);
            System.out.println("COOKIE ISIMLERI : " + w.getName());
        }

//      Bir Cookie yi ismiyle bul
        System.out.println("Cookie'yi ismiyle cagirdik "+driver.manage().getCookieNamed("skin"));

//      Yeni bir cookie ekle
        Cookie favoriCookie = new Cookie("cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookie);
        System.out.println("Yeni cookie sayisi : "+driver.manage().getCookies().size());

//      Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("skin");
        System.out.println("Yeni cookie sayisi : "+driver.manage().getCookies().size());

//      Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("Yeni cookie sayisi : "+driver.manage().getCookies().size());

    }
}
