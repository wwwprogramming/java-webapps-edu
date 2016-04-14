package edu.uta.sis.app1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Hannu Lohtander on 14.4.2016.
 */
@Controller
public class RestExamplesController {

    @RequestMapping(value = "/rest1", produces = "application/json")
    @ResponseBody
    public String rest1(Model model) {
        return "OK";
    }

    @RequestMapping(value = "/rest2/{id}", produces = "application/json")
    @ResponseBody
    public String rest2(@PathVariable("id") Integer id) {
        return "OK-" + id;
    }

    @RequestMapping(value = "/rest3")
    @ResponseBody
    public FastCar rest3() {
        FastCar fastCar = new FastCar();
        fastCar.setSpeed(101);
        fastCar.setColor("RED");
        return fastCar;
    }




}
