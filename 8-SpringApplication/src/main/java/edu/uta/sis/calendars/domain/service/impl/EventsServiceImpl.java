package edu.uta.sis.calendars.domain.service.impl;



import edu.uta.sis.calendars.data.entities.EventEntity;
import edu.uta.sis.calendars.data.repository.EventsRepository;
import edu.uta.sis.calendars.domain.data.Event;
import edu.uta.sis.calendars.domain.service.EventsService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Service
public class EventsServiceImpl implements EventsService {


    @Autowired
    EventsRepository eventsRepository;

    @Transactional(readOnly = true)
    public List<Event> getEvents(DateTime start, DateTime end) {
        List<EventEntity> list = eventsRepository.search(start,end);
        ArrayList<Event> events = new ArrayList<Event>(list.size());
        for (EventEntity ee: list) {
            Event e = new Event();
            BeanUtils.copyProperties(ee,e);
            events.add(e);
        }
        return events;
    }

    @Transactional(readOnly = true)
    public List<Event> getEvents() {
        List<EventEntity> list = eventsRepository.findAll();
        ArrayList<Event> events = new ArrayList<Event>(list.size());
        for (EventEntity ee: list) {
            Event e = new Event();
            BeanUtils.copyProperties(ee,e);
            events.add(e);
        }
        return events;
    }

    @Transactional(readOnly = true)
    public Event get(Integer id) {

        EventEntity ee =  eventsRepository.find(id);
        Event e = new Event();
        BeanUtils.copyProperties(ee,e);
        return e;
    }

    @Transactional(readOnly = false)
    public void update(Event event) {
        EventEntity ee = eventsRepository.find(event.getId());
        BeanUtils.copyProperties(event,ee);
        eventsRepository.update(ee);
    }

    @Transactional(readOnly = false)
    public Event remove(Event event) {
        EventEntity ee = eventsRepository.remove(event.getId());
        BeanUtils.copyProperties(ee,event);
        return event;
    }

    @Transactional(readOnly = false)
    public void create(Event event) {
        EventEntity ee = new EventEntity();
        BeanUtils.copyProperties(event,ee);
        eventsRepository.add(ee);
        // copy id and other stuff like created timestamp
        BeanUtils.copyProperties(ee,event);
    }
}
