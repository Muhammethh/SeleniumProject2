package day13_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExists {


    @Test
    public void fileExistsTest() {

         /*
        System.getProperty("user.dir") komutu java da programın suanda calistigi dizini verir
        (current working directory)
         */

        System.out.println(System.getProperty("user.dir")); //C:\Users\muhammet\IdeaProjects\SeleniumProject2

        System.out.println(System.getProperty("user.home")); //C:\Users\muhammet


/*
        System.getProperty("user.home") methodu bilgisiyarimizdaki herkeste farkli olan home directoryi verir
        =>Dolayisiyla herkeste calisan dynamic path elde edebilmek icin bu kısım ile herkeste ortak olan pathi birlesitiriz

        Bilgisayarimizdaki herhangi bir dosyanin varligini test edebilmemiz icin;
        1- Oncelikle varligini test etmek istedigimiz dosyanin yoluna ihtiyacimiz var.
        2- Aldigimiz dosya yolunu Files.exists(Paths.get(DOSYA YOLU)) kodu ile varligini test edebiliriz
         */


        //Bilgisayarimizdaki masasüstünde bulunan bir dosyanin varligini doğrulayalim
        //"C:\Users\muhammet\Desktop\Batch254.txt"

        String herkesteOrtakOlanYol = "\\Desktop\\Batch254.txt";
        String herkesteFarklıOlanYol = System.getProperty("user.home");

        String dynamicPath = herkesteFarklıOlanYol + herkesteOrtakOlanYol;

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));


    }
}
