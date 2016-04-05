package edu.uta.sis.spring;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "", "/home"})
    public String justAnotherRandomName(Principal principal) {
        // So do I have user now? principal can be NULL!
        System.out.println(principal);
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            WwwUser user = ((WwwUser)((UsernamePasswordAuthenticationToken) principal).getPrincipal());
            System.out.println(user.getUsername());
        }

        return "/home";
    }

    @RequestMapping(value = {"/afterlogin"})
    public String afterLogin(Principal principal) {
        // So do I have user now?
        System.out.println(principal);

        if (principal instanceof UsernamePasswordAuthenticationToken) {
            System.out.println(principal.getName());
            System.out.println(principal.getClass().getName());
            WwwUser user = ((WwwUser)((UsernamePasswordAuthenticationToken) principal).getPrincipal());
            System.out.println(user.getUsername());
        }

        Object principal2 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            System.out.println(authentication.getPrincipal());
            System.out.println(authentication.getPrincipal().getClass().getName());
            // Principal is String
            String anonymousName = (String) ((AnonymousAuthenticationToken)authentication).getPrincipal();
            System.out.println(anonymousName);
        }

        if (principal2 instanceof UserDetails) {
            String username = ((UserDetails)principal2).getUsername();
        } else {
            // AnonymousAuthenticationToken
            System.out.println(principal2.getClass().toString());
            String username = principal2.toString();
        }

        return "/home";
    }

    @RequestMapping(value = {"/justatest"})
    public String justatest(Principal principal, @AuthenticationPrincipal WwwUser user) {
        System.out.println(principal);
        System.out.println(user);
        return "/home";
    }


}
