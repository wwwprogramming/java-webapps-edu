package edu.uta.sis.spring;

import edu.uta.sis.spring.form.ExampleForm;
import edu.uta.sis.spring.form.ExampleForm2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
@Controller
public class PostController {

    @RequestMapping(value = "/post1", method = RequestMethod.POST)
    public String post1(Model model, @RequestParam("atext") String atext, @RequestParam("bselect") String bselect, @RequestParam("chidden") String chidden) {
        model.addAttribute("value1", atext);
        model.addAttribute("value2", bselect);
        model.addAttribute("value3", chidden);

        return "/post";
    }

    @RequestMapping(value = "/post2", method = RequestMethod.POST)
    public String post2(@ModelAttribute("exampleForm")ExampleForm form) {
        System.out.println(form);
        return "/post";
    }

    @RequestMapping(value = "/post3", method = RequestMethod.POST)
    public String post3(@ModelAttribute("exampleForm2") ExampleForm2 form) {
        System.out.println(form);
        return "/post";
    }



}
