package edu.uta.sis.calendars.data.repository;

import edu.uta.sis.calendars.data.entities.CalendarEntity;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
public interface CalendarRepository {

    public void save(CalendarEntity entity);

    public CalendarEntity find(Integer id);
}
