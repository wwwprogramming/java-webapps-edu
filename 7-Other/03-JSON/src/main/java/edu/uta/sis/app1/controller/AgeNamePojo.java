package edu.uta.sis.app1.controller;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */
public class AgeNamePojo {

    Integer age;
    String name;

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

    @Override
    public String toString() {
        return "AgeNamePojo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
