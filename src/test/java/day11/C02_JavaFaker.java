package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest() {

//      1. Faker obj olustur
        Faker faker = new Faker();

//      2. Faker obj ile fake data olustur
        //isim
        System.out.println("first name : "+faker.name().firstName());

        //soyisim
        System.out.println("last name : "+faker.name().lastName());

        //kullanici adi
        System.out.println(faker.name().username());

        //eyalet
        System.out.println(faker.address().state());

        //tam adres
        System.out.println(faker.address().fullAddress());

        //cep tel
        System.out.println(faker.phoneNumber().cellPhone());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //email
        System.out.println(faker.internet().emailAddress());

        //rastgele 15 bas sayi
        System.out.println(faker.number().digits(15));


    }
}
/*
TEST DATA : kullanici adi, sifre, tel no, kart no...
Test datalari kimden alinir ?
1- Business Analyst - BA
2- Test Lead
3- Manuel Tester
4- Tech Lead & Team Lead & Dev Lead
5- Developer
6- Database
7- Api call'lar
8- Dokumantasyonlar
9- Java Faker

Nerden gelmez?
1- Kullanicidan
2 - Scrum master
 */