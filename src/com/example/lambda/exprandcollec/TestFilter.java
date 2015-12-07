package com.example.lambda.exprandcollec;

import com.example.lambda.Person;

import java.util.List;

/**
 * Created by d329312 on 7/12/2015.
 */
public class TestFilter {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

        System.out.println("\n=== Western Pilot Phone List ===");

        pl.stream().filter(search.getCriteria("allPilots"))
                .forEach(Person::printWesternName);


        System.out.println("\n=== Eastern Draftee Phone List ===");

        pl.stream().filter(search.getCriteria("allDraftees"))
                .forEach(Person::printEasternName);

    }
}