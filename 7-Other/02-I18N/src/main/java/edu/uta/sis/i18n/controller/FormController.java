package edu.uta.sis.i18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Hannu Lohtander on 6.4.2016.
 */
@Controller
public class FormController {

    @RequestMapping("/form")
    public String form() {

        return "/form/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String formpost(@Valid @ModelAttribute("form") ExampleForm form, BindingResult bindingResult) {

        return "/form/form";
    }


}
