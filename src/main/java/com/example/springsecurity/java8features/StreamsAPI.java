package com.example.springsecurity.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsAPI {

    public static void main(String[] args){
        System.out.println("JAVA 8 Stream API");
        Stream<Integer> streamIterated = Stream.iterate(1, n -> n + 1).limit(10);
        streamIterated.forEach(System.out::println);
        List<String> list = Arrays.asList("abc", "abc2", "ab22c3");
        Optional<String> stream = list.stream().filter(element -> {
            return element.contains("22");
        }).map(element -> {
            return element.toUpperCase();
        }).findFirst();

        stream.ifPresent(data->System.out.println(data));
    }
}
