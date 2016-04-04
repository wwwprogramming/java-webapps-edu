package edu.uta.sis.spring.form;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
public class JustPojo {

    // default constructor was at least once upon time required
    public JustPojo() {

    }

    String extra;

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "JustPojo{" +
                "extra='" + extra + '\'' +
                '}';
    }
}
