package javaFakerDataGenerator;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

    static Faker faker=new Faker();

    public static void main(String[] args) {
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().cityName());
        System.out.println(faker.address().country());
        System.out.println(faker.address().countryCode());
        System.out.println(faker.address().secondaryAddress());
        System.out.println(faker.programmingLanguage());
        System.out.println(faker.company().name());
    }
}
