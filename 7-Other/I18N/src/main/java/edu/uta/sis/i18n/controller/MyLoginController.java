package edu.uta.sis.i18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 6.4.2016.
 */
@Controller
public class MyLoginController {


    @RequestMapping("/mylogin")
    public String mylogin() {

        return "/login/mylogin";
    }

    @RequestMapping("/loggedin")
    public String loggeddin() {

        return "/login/loggedin";
    }

    @RequestMapping("/loggedout")
    public String loggedout() {

        return "/login/loggedout";
    }
}
