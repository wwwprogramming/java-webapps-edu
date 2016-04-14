package edu.uta.sis.app1.controller;

/**
 * Created by Hannu Lohtander on 14.4.2016.
 */
public class FastCar {

    Integer speed;
    String color;

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "FastCar{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }
}
