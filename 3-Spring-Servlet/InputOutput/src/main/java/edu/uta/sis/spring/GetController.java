package edu.uta.sis.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */

@Controller
public class GetController {


    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public String get1() {

        return "/get";
    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    public String get2(@RequestParam("id") String id, Model model) {
        System.out.println(id);
        model.addAttribute("theParameter1", "-" + id);
        return "/get";
    }

    @RequestMapping(value = "/get3/{id}", method = RequestMethod.GET)
    public String get3(@PathVariable("id") String id, @RequestParam("name") String name, Model model) {
        System.out.println(id);
        model.addAttribute("theParameter1", "-" + id);
        model.addAttribute("theParameter2", "-" + name);
        return "/get";
    }


}
