package edu.uta.sis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by Hannu Lohtander on 3.3.2016.
 */
@Controller
@RequestMapping("/binddemo")
public class BindValidateController {

    @RequestMapping("/form")
    public String doBindForm() {
        return "/bindtestform";
    }

    @Autowired
    Validator validator;

    @RequestMapping(value="/post", method = RequestMethod.POST)
    public String doBindTest(@ModelAttribute BindValidateForm form, Model model) {
        //....
        return "/bindtestresult1";
    }

    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    public String doBindTestValid(@Valid @ModelAttribute("form") BindValidateForm form , BindingResult bindingResult) {
        //....
        return "/bindtestresult";
    }

    @RequestMapping(value = "/validated", method = RequestMethod.POST)
    public String doBindTestValidated(@Validated @ModelAttribute("form") BindValidateForm form, BindingResult bindingResult) {
        //....
        return "/bindtestresult";
    }

    @RequestMapping(value = "/validmanual", method = RequestMethod.POST)
    public String doBindTestValidManual(@ModelAttribute("form") BindValidateForm form, BindingResult bindingResult) {

        validator.validate(form, bindingResult);
        //.... get the validtor. Validate form
        return "/bindtestresult";
    }


}
