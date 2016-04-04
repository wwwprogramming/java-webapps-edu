package edu.uta.sis.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */

@Controller
@RequestMapping("/quotes/*")
public class QuotesController {

    @RequestMapping(method = RequestMethod.GET)
    public String list() {

        return "/quotes/list";
    };

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {

        return "/quotes/create";
    };

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createpost() {

        return "quotes/created";
    };


}
