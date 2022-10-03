package com.example.springsecurity.entity;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Books {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name="book_name")
    String name;
}
