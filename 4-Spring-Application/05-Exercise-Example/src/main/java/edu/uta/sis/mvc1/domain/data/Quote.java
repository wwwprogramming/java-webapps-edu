package edu.uta.sis.mvc1.domain.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
public class Quote {

    Integer id;

    @NotEmpty
    String quote;
    @NotNull
    Integer year;
    @NotEmpty
    String who;

    public Quote() {}

    public Quote(Integer id, String quote,Integer year, String who) {
        this.id = id;
        this.quote = quote;
        this.year = year;
        this.who = who;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
