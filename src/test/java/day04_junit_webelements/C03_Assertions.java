package day04_junit_webelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_Assertions {

/*JUnit 4 te assertion yapmak için Assert classi kullanılır
JUnit 5 te assertion yapmak için Assertions classi kullanılır*/

    @Test
    public void Test01() {

        String expectedData = "Junit5";
        String actualData = "Junit5";

        assertEquals(expectedData, actualData);

    }

    @Test
    public void Test02() {

        Assertions.assertTrue("junit".contains("U"));

    }

    @Test
    public void Test03() {

        Assertions.assertFalse(5 > 3);

    }

    @Test
    public void Test04() {

        Assertions.assertNotEquals("JUNIT5", "JUNIT4");
        System.out.println("BU MESAJ KONSOLDA GÖRÜLÜR");

        Assertions.assertNotEquals("JUNIT", "JUNIT");
        System.out.println("BU MESAJ KONSOLDA GÖRÜNMEZ");

    }

    @Test
    public void Test05() {

        char[] expectedArray = {'j', 'u', 'n', 'i', 't'};
        char[] actualArray = {'j', 'u', 'i', 'n', 't'};  //n ve i harfleri farklı

        Assertions.assertArrayEquals(expectedArray, actualArray);
        //NOT: iki arrayin eşit olması için aynı indexte aynı eleman olmalıdır
    }

    @Test
    public void Test06() {

        String str = null;
        Assertions.assertNull(str);

        //Parantez içinde belirtilen değer null ise test geçer değilse kalır
    }

    @Test
    public void Test07() {

        String str = null;
        Assertions.assertNotNull(str);

        //Parantez içinde belirtilen değer null ise test kalır değilse geçer
    }



}
