package edu.uta.sis.spring.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
@Controller
public class IndexController {


    @RequestMapping(value = {"", "/", "/home"})
    public String home() {

        return "/home";
    }

}
