package edu.uta.sis.calendars.data.repository;



import edu.uta.sis.calendars.data.entities.EventEntity;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
public interface EventsRepository {

    public void add(EventEntity eventEntity);

    public void update(EventEntity eventEntity);

    public EventEntity find(Integer id);

    public EventEntity remove(Integer id);

    public List<EventEntity> findAll();

    public List<EventEntity> search(DateTime start, DateTime end);

}
