package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by d329312 on 4/12/2015.
 */
public class Person {
    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private String eMail;
    private String phone;
    private String address;

    public static class Builder {
        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private String eMail;
        private String phone;
        private String address;

        public Builder() {
        }
        public Builder givenName(String value) {
            givenName = value;
            return this;
        }
        public Builder surName(String value) {
            surName = value;
            return this;
        }
        public Builder age(int value) {
            age = value;
            return this;
        }
        public Builder gender(Gender value) {
            gender = value;
            return this;
        }
        public Builder email(String value) {
            eMail = value;
            return this;
        }
        public Builder phoneNumber(String value) {
            phone = value;
            return this;
        }
        public Builder address(String value) {
            address = value;
            return this;
        }
        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        eMail = builder.eMail;
        phone = builder.phone;
        address = builder.address;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static List<Person> createShortList() {
        List<Person> people = new ArrayList<>();

        people.add(
                new Person.Builder()
                        .givenName("Bob")
                        .surName("Baker")
                        .age(21)
                        .gender(Gender.MALE)
                        .email("bob.baker@example.com")
                        .phoneNumber("201-121-4678")
                        .address("44 4th St, Smallville, KS 12333")
                        .build()
        );

        people.add(
                new Person.Builder()
                        .givenName("Jane")
                        .surName("Doe")
                        .age(25)
                        .gender(Gender.FEMALE)
                        .email("jane.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St, Smallville, KS 12333")
                        .build()
        );

        people.add(
                new Person.Builder()
                        .givenName("John")
                        .surName("Doe")
                        .age(25)
                        .gender(Gender.MALE)
                        .email("john.doe@example.com")
                        .phoneNumber("202-123-4678")
                        .address("33 3rd St, Smallville, KS 12333")
                        .build()
        );

        return people;
    }

    public void printWesternName(){

        System.out.println("\nName: " + this.getGivenName() + " " + this.getSurName() + "\n" +
                "Age: " + this.getAge() + "  " + "Gender: " + this.getGender() + "\n" +
                "EMail: " + this.getEmail() + "\n" +
                "Phone: " + this.getPhone() + "\n" +
                "Address: " + this.getAddress());
    }



    public void printEasternName(){

        System.out.println("\nName: " + this.getSurName() + " " + this.getGivenName() + "\n" +
                "Age: " + this.getAge() + "  " + "Gender: " + this.getGender() + "\n" +
                "EMail: " + this.getEmail() + "\n" +
                "Phone: " + this.getPhone() + "\n" +
                "Address: " + this.getAddress());
    }

    public String printCustom(Function<Person, String> f){
        return f.apply(this);
    }
}

