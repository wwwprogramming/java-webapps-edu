package edu.uta.sis.calendars.web.events;

import edu.uta.sis.calendars.domain.data.Event;
import edu.uta.sis.calendars.domain.service.EventsService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hannu Lohtander on 24.5.2016.
 */

@Controller
public class RestEventsController {

    @Autowired
    EventsService eventsService;

    @RequestMapping("/events/ajax")
    public @ResponseBody
    List<Event> getevents(@RequestParam("start")@DateTimeFormat(pattern = "yyyyMMddHHmm") DateTime start,
                          @RequestParam("end")@DateTimeFormat(pattern = "yyyyMMddHHmm") DateTime end) {

        /*
        List<Event> events = new ArrayList<Event>();

        Event e1 = new Event();
        e1.setId(1);
        e1.setTitle("e 1 title");
        e1.setStart(new DateTime(2016, 6, 16, 12, 0, 0, 0));
        e1.setEnd(new DateTime(2016, 6, 16, 14, 30, 0, 0));
        events.add(e1);
        Event e2 = new Event();
        e2.setId(2);
        e2.setTitle("e 2 title");
        e2.setStart(new DateTime(2016, 7, 14, 10, 0, 0, 0));
        e2.setEnd(new DateTime(2016, 7, 14, 14, 30, 0, 0));
        events.add(e2);
        */

        List<Event> events = eventsService.getEvents();

        // List<Event> events = eventsService.getEvents(start,end);
        return events;
    }

    @RequestMapping("/events/search")
    public @ResponseBody
    List<Event> search (@RequestParam("start")@DateTimeFormat(pattern = "yyyyMMddHHmm") DateTime start,
                          @RequestParam("end")@DateTimeFormat(pattern = "yyyyMMddHHmm") DateTime end) {
        List<Event> events = eventsService.getEvents(start, end);
        return events;
    }

}
