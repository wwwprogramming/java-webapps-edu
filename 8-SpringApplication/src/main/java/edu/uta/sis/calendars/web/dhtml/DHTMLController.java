package edu.uta.sis.calendars.web.dhtml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 29.5.2016.
 */
@Controller
public class DHTMLController {

    @RequestMapping("/dhtml/jq")
    public String jq() {
        return "/jsp/dhtml/jq/jq";
    }

    @RequestMapping("/dhtml/ng")
    public String ng() {
        return "/jsp/dhtml/ng/ng";
    }

    @RequestMapping("/dhtml/react")
    public String react() {
        return "/jsp/dhtml/react/react";
    }

}
