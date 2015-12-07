package com.example.lambda;

/**
 * Created by d329312 on 4/12/2015.
 */
import java.util.List;
import com.example.lambda.Predicate;


public class RoboContactLambda {
    public void phoneContacts(List<Person> pl, Predicate<Person> pred){
        for(Person p:pl){
            if (pred.test(p)){
                roboCall(p);
            }
        }
    }

    public void emailContacts(List<Person> pl, Predicate<Person> pred){
        for(Person p:pl){
            if (pred.test(p)){
                roboEmail(p);
            }
        }
    }

    public void mailContacts(List<Person> pl, Predicate<Person> pred){
        for(Person p:pl){
            if (pred.test(p)){
                roboMail(p);
            }
        }
    }

    public void roboCall(Person p){
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone() + " gender " + p.getGender().toValue());
    }

    public void roboEmail(Person p){
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail() + " gender " + p.getGender().toValue());
    }

    public void roboMail(Person p){
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress() + " gender " + p.getGender().toValue());
    }

}