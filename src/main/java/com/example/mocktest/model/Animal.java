package com.example.mocktest.model;

import lombok.Data;

import java.util.List;

@Data
public class Animal {

    private String name;
    private int age;
    private Boolean isFly;
    List<String> animalList;


}
