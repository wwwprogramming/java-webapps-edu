package edu.uta.sis.app1.controller;

import java.util.HashMap;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */
public class AgeNamePojo2 {

    Integer age;
    String name;
    HashMap<String,String> extra;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getExtra() {
        return extra;
    }

    public void setExtra(HashMap<String, String> extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "AgeNamePojo2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", extra=" + extra +
                '}';
    }
}
