package edu.uta.sis.spring;

import edu.uta.sis.spring.form.ExampleForm;
import edu.uta.sis.spring.form.ExampleForm2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
@Controller
public class PostController {

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String post() {

        return "/form/example";
    }

    @RequestMapping(value = "/post1", method = RequestMethod.POST)
    public String post1(Model model, @RequestParam("atext") String atext, @RequestParam("bselect") String bselect, @RequestParam("chidden") String chidden) {
        model.addAttribute("value1", atext);
        model.addAttribute("value2", bselect);
        model.addAttribute("value3", chidden);

        return "/form/example";
    }

    @RequestMapping(value = "/post2", method = RequestMethod.POST)
    public String post2(@ModelAttribute("exampleForm")ExampleForm form) {
        System.out.println(form);
        return "/form/example";
    }

    @RequestMapping(value = "/post3", method = RequestMethod.POST)
    public String post3(@ModelAttribute("exampleForm2") ExampleForm2 form) {
        System.out.println(form);
        return "/form/example";
    }

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
