package edu.uta.sis.calendars.domain.service;

import edu.uta.sis.calendars.domain.data.Event;

import java.util.List;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
public interface EventsService {

    public List<Event> getEvents();

    public Event get(Integer id);

    public void update(Event q);

    public Event remove(Event q);

    public void create(Event q);
}
