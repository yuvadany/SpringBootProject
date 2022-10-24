package com.example.springsecurity.java8features;

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

    List<String> names = Arrays.asList("Larry", "Steve", "James");
    public  List<String> persons = new ArrayList<String>();



    // persons.add("Larry);
       // persons.add("Steve");
       // persons.add("James);
                //forEach(System.out::println);
    //names.for

}
