package edu.uta.sis.calendars.web.events;

import edu.uta.sis.calendars.domain.data.Event;
import edu.uta.sis.calendars.domain.service.EventsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Controller
public class EventsController {

    Logger logger = Logger.getLogger(this.getClass().getName());


    @Autowired
    EventsService eventsService;

    @InitBinder
    public void initBInder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value ={"/events","/events/list"})
    public String list(Model model) {
        logger.debug("List Events");

        model.addAttribute("events", eventsService.getEvents());
        return "/jsp/calendar/list";
    }

    @RequestMapping(value ={"/events/calendar"})
    public String calendar(Model model) {
        logger.debug("List Events");

        model.addAttribute("events", eventsService.getEvents());
        return "/jsp/calendar/calendar";
    }

    @RequestMapping(value ={"/events2","/events2/list"})
    public String list2(Model model) {
        logger.debug("List Events");

        model.addAttribute("events", eventsService.getEvents());
        return "/events/index2";
    }

    @RequestMapping(value ={"/events3","/events3/list"})
    public String list3(Model model) {
        logger.debug("List Events");

        model.addAttribute("events", eventsService.getEvents());
        return "/events/index3";
    }

    @RequestMapping(value = "/event/create", method = RequestMethod.GET)
    public String create(Model model) {
        logger.debug("Create Event");
        model.addAttribute("event", new Event());
        return "/events/create";
    }

    @RequestMapping(value = "/event/create", method = RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {
        logger.debug("Create Event");
        if (bindingResult.hasErrors()) {
            return "/events/read";
        }
        eventsService.create(event);
        // just adding empty quote, so quote.id in the jsp exist, even though is null
        return "redirect:/events/list";
    }

    @RequestMapping(value = "/event/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Model model) {
        logger.debug("UPDATE Event " + id);
        Event event = eventsService.get(id);
        model.addAttribute("event", event);
        return "/events/update";
    }

    @RequestMapping(value = "/event/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Integer id, Model model, @Valid @ModelAttribute("event") Event event, BindingResult bindingResult) {
        logger.debug("UPDATE Event " + id);
        if (bindingResult.hasErrors()) {
            return "/events/update";
        }
        event.setId(id);
        eventsService.update(event);

        return "redirect:/events/list";
    }

    @RequestMapping(value = "/event/remove/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id) {
        logger.debug("REMOVE Event " + id);

        eventsService.remove(eventsService.get(id));

        return "redirect:/events/list";
    }

    @RequestMapping(value = "/event/read/{id}", method = RequestMethod.GET)
    public String read(@PathVariable("id") Integer id, Model model) {
        logger.debug("READ Event " + id);

        Event event = eventsService.get(id);
        model.addAttribute("event", event);

        return "/events/read";
    }


}
