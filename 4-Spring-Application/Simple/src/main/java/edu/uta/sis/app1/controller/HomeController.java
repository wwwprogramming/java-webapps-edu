package edu.uta.sis.app1.controller;

import edu.uta.sis.app1.domain.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("hello", homeService.getHello());
        return "/home";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        model.addAttribute("hello", homeService.getHello2());
        return "/home";
    }

}
