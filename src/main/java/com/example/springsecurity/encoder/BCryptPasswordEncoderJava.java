package com.example.springsecurity.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderJava {
    public static void main(String args[]){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("admin");
        System.out.println(" BCryptPasswordEncoder -- "+password);
    }
}
