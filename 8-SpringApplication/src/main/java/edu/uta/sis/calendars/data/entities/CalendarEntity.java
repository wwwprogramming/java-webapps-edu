package edu.uta.sis.calendars.data.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
@Entity
@Table(name= "calendar")
public class CalendarEntity {

    @Id
    @GeneratedValue
    Integer id;

    String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "calendar")
    List<EventEntity> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }
}
