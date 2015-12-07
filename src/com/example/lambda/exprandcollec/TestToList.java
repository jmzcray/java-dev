package com.example.lambda.exprandcollec;

import com.example.lambda.Person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by d329312 on 7/12/2015.
 */

public class TestToList {

    public static void main(String[] args) {

        List<Person> pl = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

        // Make a new list after filtering.
        List<Person> pilotList = pl
                .stream()
                .filter(search.getCriteria("allPilots"))
                .collect(Collectors.toList());

        System.out.println("\n=== Western Pilot Phone List ===");
        pilotList.forEach(Person::printWesternName);

    }

}