package edu.uta.sis.spring.security;

import edu.uta.sis.spring.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hannu Lohtander on 1.5.2016.
 */
public class MyDemoFilter extends OncePerRequestFilter {

    UserService userService;

    public MyDemoFilter() {
    }

    // <property name="userService" ref="..."/> - this method is called to set value
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JUST A DEMO FILTER!");
        filterChain.doFilter(request, response);
    }
}
