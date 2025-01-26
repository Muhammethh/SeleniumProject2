package day11_basicAuthentication_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {


    /*
    cookie denildiğinde akla manage() methodu gelmeli çünkü cookieler ile ilgili tüm işlemleri
     manage() methodu sayesinde yapabiliriz
     */


    @Test
    void test01() {

        // 1- Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        // 2- Tüm cookie'leri consola bir loop ile yazdırın
        Set<Cookie> cookies = driver.manage().getCookies();

        int counter = 1;
        for (Cookie w : cookies) {

            System.out.println(counter + ". cookie ==> " + w);
            System.out.println(counter + ". cookie name ==> " + w.getName());
            System.out.println(counter + ". cookie value ==> " + w.getValue());
            System.out.println("=====================================");
            counter++;

        }

        // 3- Sayfadaki cookies sayısının 5'den büyük olduğunu test edin
        Assertions.assertTrue(cookies.size() > 5);

        // 4- İsmi i18n-prefs olan cookie değerinin USD olduğunu test edin
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assertions.assertEquals("USD",cookieValue);

        // 5- İsmi "en sevdigim cookie" ve değeri "çikolatalı" olan bir cookie oluşturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdiğim cookie","çikolatalı cookie");
        driver.manage().addCookie(cookie);

        // 6- Eklediğiniz cookie'nin sayfaya eklendiğini test edin
        cookies = driver.manage().getCookies();
        Assertions.assertTrue(cookies.contains(cookie));


        int counter1 = 1;
        for (Cookie w : cookies) {

            System.out.println(counter1 + ". cookie ==> " + w);
            System.out.println(counter1 + ". cookie name ==> " + w.getName());
            System.out.println(counter1 + ". cookie value ==> " + w.getValue());
            System.out.println("=====================================");
            counter1++;

        }

        // 7- İsmi skin olan cookie'yi silin ve silindiğini test edin
        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();

        //Assertions.assertFalse(cookies.contains(driver.manage().getCookieNamed("skin"))); bu da olur
        Assertions.assertNull(driver.manage().getCookieNamed("skin"));


        // 8- Tüm cookie'leri silin ve silindiğini test edin
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        Assertions.assertTrue(cookies.isEmpty());


    }


}
