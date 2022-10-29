package com.example.springsecurity.java8features;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JavaTime {
    public static void main(String[] args) {
        System.out.println("   Local Date");
        System.out.println(LocalDate.now());

        System.out.println("  Local Time");
        System.out.println(LocalTime.now());

        System.out.println("   Local Date Time");
        System.out.println(LocalDateTime.now());
    }
}
