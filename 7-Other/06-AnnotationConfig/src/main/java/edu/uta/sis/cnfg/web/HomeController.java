package edu.uta.sis.cnfg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {



    @RequestMapping(value = {"", "/", "/home"})
    public String home(Model model) {

        return "/home";
    }



}
