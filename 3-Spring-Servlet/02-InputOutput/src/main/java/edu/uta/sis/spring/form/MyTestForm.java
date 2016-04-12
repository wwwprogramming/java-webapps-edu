package edu.uta.sis.spring.form;

/**
 * Created by Hannu Lohtander on 7.4.2016.
 */
public class MyTestForm {

    String name;

    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyTestForm{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
