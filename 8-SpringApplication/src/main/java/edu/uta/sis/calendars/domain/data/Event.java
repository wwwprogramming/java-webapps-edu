package edu.uta.sis.calendars.domain.data;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
public class Event {

    Integer id;

    @NotEmpty
    String title;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    DateTime start;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    DateTime end;

    String description;

    Integer userId;

    Integer username;

    public Event() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }
}
