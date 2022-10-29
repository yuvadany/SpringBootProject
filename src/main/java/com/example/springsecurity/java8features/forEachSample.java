package com.example.springsecurity.java8features;

import com.example.springsecurity.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class forEachSample {
    //In Java, the Collection interface has Iterable as its super interface.
    // And this interface has a new API starting with Java 8
    //void forEach(Consumer<? super T> action)

    //@FunctionalInterface
    //public interface Consumer {
    //    void accept(T t);}
    public static void main(String[] args0) {
        List<String> names = Arrays.asList("Larry", "Steve", "James");
        names.forEach(System.out::println);

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("yuvaraj", 35));
        persons.add(new Person("Nirtara", 1));
        persons.add(new Person("Nivaan", 4));

        List<String> personsList = new ArrayList<>();

        persons.forEach(data-> {if(data.getAge()>1)
        personsList.add(data.getName());});


        System.out.println("Persons with Age above 1 ");
        personsList.forEach(System.out::println);
    }

    // persons.add("Larry);
    // persons.add("Steve");
    // persons.add("James);
    //forEach(System.out::println);
    //names.for

}
