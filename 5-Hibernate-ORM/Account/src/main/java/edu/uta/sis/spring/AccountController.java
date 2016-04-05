package edu.uta.sis.spring;

import edu.uta.sis.spring.tietokanta.entiteetit.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Hannu Lohtander on 5.4.2016.
 */
@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/account/register", method = RequestMethod.GET)
    public String register() {

        return "/account/register";
    }

    @RequestMapping(value = "/account/register", method = RequestMethod.POST)
    public String register2(@ModelAttribute("user") UserRegisterForm user, Model model) {
        userService.register(new WwwUser(null, user.getUsername(), user.getPassword(), user.getEmail(), user.getRole()));

        WwwUser u2 = userService.getUser(user.getUsername());
        model.addAttribute("u2", u2);
        return "/account/registered";
    }

    @RequestMapping(value = "/account/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.getUsers());

        return "/account/list";
    }


}
