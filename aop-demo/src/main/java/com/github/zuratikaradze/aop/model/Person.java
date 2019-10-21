package com.github.zuratikaradze.aop.model;

import com.github.zuratikaradze.aop.aspect.Loggable;

public class Person {
    String name="personName";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
