package edu.uta.sis.mvc1.web;

import edu.uta.sis.mvc1.domain.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = {"", "/", "/home"})
    public String home(Model model) {
        //https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc

        logger.debug("I AM At the HomeController.home()");
        //(new ArrayList<String>()).get(0).getBytes();
        //new Integer("abc");
        return "/home";
    }

    @RequestMapping(value = {"/e1"})
    public String e1(Model model) {
        //https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc


        (new ArrayList<String>()).get(0).getBytes();
        //new Integer("abc");
        return "/home";
    }

    @RequestMapping(value = {"/e2"})
    public String e2(Model model) {
        new Integer("abc");
        return "/home";
    }

    @RequestMapping(value = {"/e3/{id}"})
    public String e3(@PathVariable("id") Integer id, Model model) {

        return "/home";
    }




}
