package day14_seleniumwaits_exceptions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

public class C05_NullPointerException {

    /*
    NullPointerException
    ==> Eger bir object yada variable declare edip, bu olusturdugumuz object yada variable a assignment yapmadan
    kullanmak istersek, (yani initialize etmeden) bu exceptionu aliriz
    ==> henüz olusturulmamis bir nesnen üzerinde bir islem yapmaya calistigimizda bu hata ile karsilasiriz
     */

    Actions actions;
    Faker faker;

    @Test
    void test01() {
        faker = new Faker();
        System.out.println(faker.name().fullName());//faker objectine assignment yapmadan kullandigimiz icin NullPointerException ALDIK
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
    }


}
