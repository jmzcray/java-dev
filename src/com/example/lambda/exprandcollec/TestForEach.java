package com.example.lambda.exprandcollec;

import com.example.lambda.Person;

import java.util.List;

/**
 * Created by d329312 on 7/12/2015.
 */
public class TestForEach {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        System.out.println("\n=== Western Phone List ===");
        pl.forEach( p -> p.printWesternName() );

        System.out.println("\n=== Eastern Phone List ===");
        pl.forEach(Person::printEasternName);

        System.out.println("\n=== Custom Phone List ===");
        pl.forEach(p -> { System.out.println(p.printCustom(r -> "Name: " + r.getGivenName() + " EMail: " + r.getEmail())); });

    }

}