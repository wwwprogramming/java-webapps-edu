package edu.uta.sis.calendars.data.entities;


import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * Created by Hannu Lohtander on 9.5.2016.
 */
@Entity
@Table(name= "events")
public class EventEntity {

    @Id
    @GeneratedValue
    Integer id;

    String title;

    String description;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime start;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime end;


    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime created;

    @ManyToOne
    LocationEntity location;

    @ManyToOne
    CalendarEntity calendar;

    @ManyToOne(optional = true)
    UserEntity owner;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public CalendarEntity getCalendar() {
        return calendar;
    }

    public void setCalendar(CalendarEntity calendar) {
        this.calendar = calendar;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }
}
