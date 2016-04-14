package edu.uta.sis.app1.controller;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */
public class TestForm {

    // just a string
    String date1;

    // defaults to SS
    DateTime date2;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    DateTime date3;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
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
        return "TestForm{" +
                "date1='" + date1 + '\'' +
                ", date2=" + date2 +
                ", date3=" + date3 +
                ", date4=" + date4 +
                '}';
    }
}
