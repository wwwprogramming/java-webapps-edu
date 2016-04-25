package edu.uta.sis.mvc1.web;

import edu.uta.sis.mvc1.domain.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = {"", "/", "/home"})
    public String home(Model model) {
        logger.debug("I AM At the HomeController.home()");
        return "/home";
    }



}
