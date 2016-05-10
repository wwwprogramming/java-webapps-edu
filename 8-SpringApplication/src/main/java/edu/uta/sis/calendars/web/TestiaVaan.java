package edu.uta.sis.calendars.web;

import edu.uta.sis.calendars.data.entities.CalendarEntity;
import edu.uta.sis.calendars.data.entities.EventEntity;
import edu.uta.sis.calendars.data.entities.LocationEntity;
import edu.uta.sis.calendars.data.repository.CalendarRepository;
import edu.uta.sis.calendars.data.repository.EventsRepository;
import edu.uta.sis.calendars.data.repository.LocationRepository;
import edu.uta.sis.calendars.domain.service.EventsService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
@Controller
public class TestiaVaan {

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    LocationRepository locationRepository;


    @RequestMapping("/test")
    public void test() {
        Random r = new Random();
        int rand = r.nextInt((10000 - 1) + 1) + 1;
        LocationEntity le = new LocationEntity();
        le.setName("A-" + rand);
        locationRepository.save(le);


        CalendarEntity ce = new CalendarEntity();
        ce.setName("B-" + rand);
        calendarRepository.save(ce);


        EventEntity e = new EventEntity();
        e.setCalendar(ce);
        e.setLocation(le);
        e.setTitle("title-1");
        e.setStart(DateTime.now());
        e.setEnd(DateTime.now());

        eventsRepository.add(e);


        //eventsRepository.add(e);


    }

    @RequestMapping("/test2")

    public void test2() {
        CalendarEntity calendarEntity = calendarRepository.find(2);
        System.out.println(calendarEntity);
        System.out.println(calendarEntity.getEvents());
    }

    @RequestMapping("/test3")

    public void test3() {
        EventEntity eventEntity = eventsRepository.find(5);
        System.out.println(eventEntity);
        System.out.println(eventEntity.getCalendar());
        System.out.println(eventEntity.getLocation());

    }

}
