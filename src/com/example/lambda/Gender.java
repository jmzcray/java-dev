package com.example.lambda;

/**
 * Created by d329312 on 4/12/2015.
 */
public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String gender;
    Gender(String str) {
        this.gender = str;
    }

    public String toValue() {
        return gender;
    }
}
