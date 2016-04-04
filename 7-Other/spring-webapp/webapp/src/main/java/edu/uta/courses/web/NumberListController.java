package edu.uta.courses.web;

import edu.uta.courses.service.NumberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;

/**
 * Created by me on 21.1.2015.
 */
@Controller
@SessionAttributes("arrayListOfNumbers")
public class NumberListController {

    @Autowired
    NumberListService numberListService;

    /* alternative for setting empty list to model.
    @ModelAttribute("arrayListOfNumbers")
    public ArrayList<String> createArrayListOfNumbers() {
        return new ArrayList<String>();
    }
    */

    @RequestMapping(value = "/numberlist/start", method = RequestMethod.GET)
    public String startAskingNumbers(Model model) {
        // alternative to above @ModelAttribute annotated method
        // http://stackoverflow.com/questions/4914071/i-am-confused-about-how-to-use-sessionattributes
        model.addAttribute("arrayListOfNumbers", new ArrayList<String>());
        return "/numberlist/start";
    }


    @RequestMapping(value = "/numberlist/get", method = RequestMethod.POST)
    public String getNumbers(@RequestParam("number") String number, @ModelAttribute("arrayListOfNumbers") ArrayList<String> arrayListOfNumbers,Model model) {
        // put to ArrayList<String> which is in session. Implement!
        System.out.println(number);
        System.out.println(arrayListOfNumbers);

        arrayListOfNumbers.add(number);
        // put a copy of that list to model

        model.addAttribute("arrayListOfNumbers", arrayListOfNumbers);
        return "/numberlist/ask";
    }


    @RequestMapping(value = "/numberlist/complete", method = RequestMethod.GET)
    public String getNumbers(Model model, @ModelAttribute("arrayListOfNumbers") ArrayList<String> arrayListOfNumbers, SessionStatus sessionStatus) {
        // reset/remove/invalidate ArrayList<String> which is in session. Implement!
        sessionStatus.setComplete();
        numberListService.orderNumberList(arrayListOfNumbers);
        model.addAttribute("arrayListOfNumbers", arrayListOfNumbers);
        return "/numberlist/complete";
    }

}
