package edu.uta.sis.calendars.web.dhtml;

import org.joda.time.DateTime;

/**
 * Created by Hannu Lohtander on 30.5.2016.
 */
public class Item {

    String id;
    String name;

    DateTime dt;

    public Item() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public DateTime getDt() {
        return dt;
    }

    public void setDt(DateTime dt) {
        this.dt = dt;
    }
}
