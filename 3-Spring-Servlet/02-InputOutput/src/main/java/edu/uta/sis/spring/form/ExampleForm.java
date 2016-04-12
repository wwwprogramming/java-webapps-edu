package edu.uta.sis.spring.form;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
public class ExampleForm {

    String atext;
    String bselect;
    String chidden;

    public String getAtext() {
        return atext;
    }

    public void setAtext(String atext) {
        this.atext = atext;
    }

    public String getBselect() {
        return bselect;
    }

    public void setBselect(String bselect) {
        this.bselect = bselect;
    }

    public String getChidden() {
        return chidden;
    }

    public void setChidden(String chidden) {
        this.chidden = chidden;
    }

    @Override
    public String toString() {
        return "ExampleForm{" +
                "atext='" + atext + '\'' +
                ", bselect='" + bselect + '\'' +
                ", chidden='" + chidden + '\'' +
                '}';
    }
}
