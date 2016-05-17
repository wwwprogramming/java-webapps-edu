package edu.uta.sis.app1.controller;

import edu.uta.sis.app1.domain.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */

@Controller
public class CalculatorController {

//    @Autowired
//    CalculatorService calculatorService;
    //???

    public String calculate(Model model,@RequestParam("x") Integer x, @RequestParam("y") Integer y) {
        int result = x +y;
        model.addAttribute("result", result);
        return "form";
    }

}
