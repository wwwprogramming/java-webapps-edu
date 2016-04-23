package edu.uta.sis.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", ""})
    public String homejsp() {
        return "/jsp/home";
    }



}
