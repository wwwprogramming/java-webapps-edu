package edu.uta.sis.calendars.web.account;


import edu.uta.sis.calendars.domain.data.WwwUser;
import edu.uta.sis.calendars.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String register(Model model) {
        model.addAttribute("user", new WwwUser());
        return "/account/register";
    }

    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserRegisterForm user, Model model) {
        // TODO @VALIDate
        userService.register(new WwwUser(null, user.getUsername(), user.getPassword(), user.getEmail(), user.getFullName(), "ROLE_USER"));

        WwwUser u2 = userService.getUser(user.getUsername());
        model.addAttribute("user", u2);
        return "redirect:/account/show/" + u2.getId();
    }

    @RequestMapping(value = "/account/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {

        WwwUser u = userService.getUser(id);
        model.addAttribute("user", u);
        return "/account/account";
    }

    @RequestMapping(value = {"/accounts","/account/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.getUsers());

        return "/account/list";
    }


    @RequestMapping(value = "/account/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model) {
        // @TODO
        model.addAttribute("user", userService.getUser(id));
        return "/account/update";
    }

    @RequestMapping(value = "/account/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id, Model model) {
        userService.remove(id);

        return "redirect:/accounts";
    }


}
