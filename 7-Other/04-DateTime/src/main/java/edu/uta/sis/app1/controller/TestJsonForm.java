package edu.uta.sis.app1.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */
public class TestJsonForm {

    // just a string
    String date1;

    // defaults to iso
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    DateTime date2;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    DateTime date3;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    DateTime date4;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public DateTime getDate2() {
        return date2;
    }

    public void setDate2(DateTime date2) {
        this.date2 = date2;
    }

    public DateTime getDate3() {
        return date3;
    }

    public void setDate3(DateTime date3) {
        this.date3 = date3;
    }

    public DateTime getDate4() {
        return date4;
    }

    public void setDate4(DateTime date4) {
        this.date4 = date4;
    }

    @Override
    public String toString() {
        return "TestJsonForm{" +
                "date1='" + date1 + '\'' +
                ", date2=" + date2 +
                ", date3=" + date3 +
                ", date4=" + date4 +
                '}';
    }
}
