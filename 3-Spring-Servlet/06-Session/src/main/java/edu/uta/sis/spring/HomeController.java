package edu.uta.sis.spring;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
@SessionAttributes(value = {"myTestValue"})
public class HomeController {

    @RequestMapping(value = {"/", ""})
    public String justAnotherRandomName() {
        return "/home";
    }

    @RequestMapping(value = {"/sess1"})
    public String sess1(Model model) {
        return "/sess/sess1";
    }

    @RequestMapping(value = {"/sess2"})
    public String sess2(Model model) {
        model.addAttribute("myTestValue", "RED");
        return "/sess/sess2";
    }

    @RequestMapping(value = {"/sess3"})
    public String sess3(HttpSession httpSession) {
        httpSession.removeAttribute("myTestValue");
        return "/sess/sess1";
    }

    @RequestMapping(value = {"/sess4"})
    public String sess4(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "/sess/sess1";
    }

}
