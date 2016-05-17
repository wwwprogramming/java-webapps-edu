package edu.uta.sis.spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Hannu Lohtander on 19.4.2016.
 */


@Controller
public class MyController {

    @RequestMapping(value = "/myurl")
    public String whatEva(Model model) {
        model.addAttribute("name", getName());
        return "/myjsp";
    }

    private String getName() {
        return "John";
    }

}
