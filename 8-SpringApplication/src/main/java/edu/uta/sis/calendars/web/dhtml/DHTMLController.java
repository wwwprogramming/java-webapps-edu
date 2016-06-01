package edu.uta.sis.calendars.web.dhtml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hannu Lohtander on 29.5.2016.
 */
@Controller
public class DHTMLController {

    private List<Item> items;

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

    @RequestMapping("/dhtml/post")
    public @ResponseBody String posted(@RequestBody List<Item> items) {
        this.items = items;
        return "OK";
    }

    @RequestMapping("/dhtml/data")
    public @ResponseBody List<Item> data() {

        return this.items;
    }

}
