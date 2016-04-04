package edu.uta.sis.logexample.controller;

import edu.uta.sis.logexample.domain.HomeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {


    Logger logger = Logger.getLogger(HomeController.class.getName());

    @Autowired
    HomeService homeService;

    @RequestMapping("/home")
    public String home(Model model) {
        logger.debug("home");
        logger.info("home");

        model.addAttribute("hello", homeService.getHello());
        return "/home";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        logger.debug("home2");
        logger.info("home2");

        model.addAttribute("hello", homeService.getHello2());
        return "/home";
    }

}
