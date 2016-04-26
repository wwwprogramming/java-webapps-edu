package edu.uta.sis.i18n.controller;

import edu.uta.sis.i18n.domain.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    @Autowired
    HomeService homeService;


    @RequestMapping(value={"/home", "/", ""})
    public String home(Locale locale,Model model) {

        model.addAttribute("hello", homeService.getHello());
        return "/home";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        model.addAttribute("hello", homeService.getHello2());
        return "/home";
    }

}
