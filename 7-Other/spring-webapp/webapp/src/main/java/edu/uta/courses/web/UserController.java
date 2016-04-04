package edu.uta.courses.web;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.Constants;
import edu.uta.courses.repository.domain.User;
import edu.uta.courses.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by me on 10.2.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editPersonOpen(@ModelAttribute("form") UserCreateForm form, Model model) {

        return "/user/create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String editPersonCommit(@ModelAttribute("form") UserCreateForm form, Model model) {
        User user = new User();

        user.setPassword(UserUtil.getSHA256Password(form.getPassword1(), form.getUserName()));
        user.setSecurityRoles(Constants.ROLE_USER);
        user.setHashKey("nokey");
        user.setAnonymous(Boolean.FALSE);
        // setting company user is bind to.
        user.setUserName(form.getUserName());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        // ... and so on...

        personRepository.create(user);
        model.addAttribute("currentUser", user);
        return "/user/show";
    }


}
