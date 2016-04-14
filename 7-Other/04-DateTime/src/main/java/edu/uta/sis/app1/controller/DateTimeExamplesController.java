package edu.uta.sis.app1.controller;

import edu.uta.sis.app1.domain.HomeService;
import edu.uta.sis.app1.domain.TestEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */
@Controller
public class DateTimeExamplesController {

    @Autowired
    HomeService homeService;


    @RequestMapping("/date1")
    public String date1(Model model) {

        return "/joda/date1";
    }

    @RequestMapping("/date1/{date}")
    public String date1(Model model, @PathVariable("date") String dateTime) {
        model.addAttribute("date1", dateTime);
        return "/joda/date1";
    }


    @RequestMapping("/date2")
    public String date2(Model model) {
        model.addAttribute("now", new Date());
        model.addAttribute("now2", DateTime.now());
        return "/joda/date2";
    }

    @RequestMapping("/date2/{date}")
    public String date2(Model model, @PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) DateTime dateTime) {
        model.addAttribute("now", new Date());
        model.addAttribute("now2", DateTime.now());
        model.addAttribute("now", new Date());
        model.addAttribute("date2", dateTime);
        return "/joda/date2";
    }

    @RequestMapping("/date2b")
    public String date2b(Model model, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) DateTime dateTime) {
        model.addAttribute("now", new Date());
        model.addAttribute("now2", DateTime.now());
        model.addAttribute("date2", dateTime);
        return "/joda/date2";
    }


    @RequestMapping("/date2c/{date}/")
    public String date2c(Model model, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) DateTime dateTime) {
        model.addAttribute("now", new Date());
        model.addAttribute("now2", DateTime.now());
        model.addAttribute("date2", dateTime);
        return "/joda/date2";
    }



    @RequestMapping("/date3")
    public String date3(Model model, @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") DateTime dateTime) {
        model.addAttribute("date3", dateTime);
        model.addAttribute("now", DateTime.now());
        return "/joda/date3";
    }


    @RequestMapping( value = "/date4/{date4}", method = RequestMethod.GET)
    public String date4(Model model, @PathVariable("date4")@DateTimeFormat(pattern = "ddMMyyyy") DateTime dateTime ) {
        model.addAttribute("date4", dateTime);
        model.addAttribute("now", DateTime.now());
        return "/joda/date4";
    }

    @RequestMapping( value = "/date5", method = RequestMethod.GET)
    public String date5(Model model) {
        model.addAttribute("now", DateTime.now());
        return "/joda/date5";
    }

    @RequestMapping(value = "/date5", method = RequestMethod.POST)
    public String date5(Model model, @ModelAttribute("form") TestForm form) {
        System.out.println(form);
        model.addAttribute("now", DateTime.now());
        return "/joda/date5";
    }

    @RequestMapping( value = "/date6", method = RequestMethod.GET)
    public String date6(Model model) {
        model.addAttribute("now", DateTime.now());
        return "/joda/date6";
    }

    /**
     * Form is posted here using ajax call and body is JSON encoded
     *
     * @param model
     * @param from
     * @return
     */
    @RequestMapping(value = "/date6", consumes = "application/json", method = RequestMethod.POST)
    public String date6(Model model, @RequestBody TestJsonForm form) {
        model.addAttribute("now", DateTime.now());
        System.out.println(form);
        return "/joda/date6";
    }

    @RequestMapping(value = "/hibernate6", method = RequestMethod.GET)
    public String hibernate6() {
        DateTime now = DateTime.now();
        TestEntity entity = new TestEntity();
        entity.setCreated(now);
        homeService.save(entity);
        return "/hibernate/date6";
    }

}
