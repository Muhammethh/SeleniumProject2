package day12_actions_faker;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.util.Locale;

public class C06_Faker {

    @Test
    void test01() {

        Faker faker = new Faker();

        //faker objesi ile fake bir isim yazdırınız
        System.out.println(faker.name().firstName());

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println(faker.address().fullAddress());

        //faker objesi ile fake bir telefon No yazdırınız
        System.out.println(faker.phoneNumber().cellPhone());

        //faker objesi ile fake bir email yazdırınız
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayı yazdırınız
        System.out.println(faker.number().digits(15));

        //faker objesi ile fake bir isimshowisim yazdırınız
        System.out.println(faker.name().fullName());

    }

    @Test
    public void test02() {

        Locale locale = new Locale("tr");
        Faker faker = new Faker(locale);

        System.out.println(faker.name().fullName());

    }
}
