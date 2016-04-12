package edu.uta.sis.i18n.controller;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Hannu Lohtander on 6.4.2016.
 */
public class ExampleForm {

    Integer age;

    @NotEmpty
    String color;

    @Max(value = 132)
    @Min(value = 1)
    // or use @Range()
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
