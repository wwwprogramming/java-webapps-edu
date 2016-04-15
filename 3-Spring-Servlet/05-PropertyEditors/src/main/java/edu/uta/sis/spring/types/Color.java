package edu.uta.sis.spring.types;

/**
 * Created by Hannu Lohtander on 15.4.2016.
 */
public class Color {

    public enum Colors {
        RED, BLUE, GREEN, YELLOW, BLACK, WHITE


    }

    Colors color;

    public Color(Colors color) {
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}
