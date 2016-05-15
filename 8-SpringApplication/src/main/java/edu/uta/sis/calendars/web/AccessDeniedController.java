package edu.uta.sis.calendars.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 15.5.2016.
 */
@Controller
public class AccessDeniedController {

    @RequestMapping("/accessdenied")
    public String ad() {
        // IF NEED TO LOG OR WHAT EVER
        return "/accessdenied";
    }
}
