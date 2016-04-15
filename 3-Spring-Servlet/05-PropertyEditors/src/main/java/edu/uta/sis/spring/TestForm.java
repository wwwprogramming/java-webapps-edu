package edu.uta.sis.spring;

import edu.uta.sis.spring.types.Age;
import edu.uta.sis.spring.types.Color;

/**
 * Created by Hannu Lohtander on 15.4.2016.
 */
public class TestForm {

    Age age;

    Color color;

    Integer id;


    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestForm{" +
                "age=" + age +
                ", color=" + color +
                ", id=" + id +
                '}';
    }
}
