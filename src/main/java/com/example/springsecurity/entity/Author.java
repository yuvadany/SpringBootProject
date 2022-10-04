package com.example.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="authors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
    @ApiModelProperty(notes = "The Author Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  id;
    @ApiModelProperty(notes = "The Author Name")
    @Column(name="author_name")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
