package edu.uta.sis.spring;

import edu.uta.sis.spring.editors.AgeEditor;
import edu.uta.sis.spring.editors.ColorEditor;
import edu.uta.sis.spring.types.Age;
import edu.uta.sis.spring.types.Color;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Age.class, new AgeEditor());
        binder.registerCustomEditor(Color.class, new ColorEditor());
        binder.setDisallowedFields("id");
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String justAnotherRandomName() {
        return "/home";
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public String justAnotherRandomName(Model model, @ModelAttribute("form") TestForm form) {
        System.out.println(form);
        return "/home";
    }


}
