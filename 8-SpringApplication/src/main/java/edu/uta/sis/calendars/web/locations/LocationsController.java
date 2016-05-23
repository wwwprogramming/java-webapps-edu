package edu.uta.sis.calendars.web.locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 23.5.2016.
 */
@Controller
@RequestMapping("/location")
public class LocationsController {

    @RequestMapping("/demo")
    public String mapdemo() {
        return "/jsp/location/gmap";
    }

}
