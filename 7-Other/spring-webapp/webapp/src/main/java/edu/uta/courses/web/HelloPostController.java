package edu.uta.courses.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by me on 17.1.2015.
 */

@Controller
public class HelloPostController {

    @RequestMapping(value="/formexample", method= RequestMethod.GET)
    public String getExample(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "/form/example";
    }

    @RequestMapping(value="/formexample/{dummy}", method= RequestMethod.POST)
    public String postExample(@PathVariable("dummy") String dummy, @RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("dummy", dummy);
        model.addAttribute("name", name);
        return "/form/exampled";
    }

}
