package day04_junit_webelements;

import org.junit.jupiter.api.*;

public class C01_BeforeAfter {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll notasyonuna sahip olan method classtaki tüm test methodlarından önce 1 kez çalıştırılır");
    }

    @BeforeEach
    void setUp() {

        System.out.println("@BeforeEach notasyonuna sahip olan bir method her bir test methodundan önce bir kez çalıştırılır");

    }

    @Test
    public void test01() {

        System.out.println("Test01 çalıştı");

    }

    @Test
    public void test02() {

        System.out.println("Test02 çalıştı");

    }

    @Test
    public void test03() {

        System.out.println("Test03 çalıştı");

    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach notasyonuna sahip olan bir method her bir test methodundan sonra bir kez çalıştırılır");
    }


    @AfterAll
    static void afterAll() {

        System.out.println("@AfterAll notasyonuna sahip olan method classtaki tüm test methodlarından sonra 1 kez çalıştırılır");

    }


}
