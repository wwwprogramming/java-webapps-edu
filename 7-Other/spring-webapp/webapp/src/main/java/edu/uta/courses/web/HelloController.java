package edu.uta.courses.web;

import edu.uta.courses.repository.domain.WwwUser;
import edu.uta.courses.util.UserUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by me on 3.1.2015.
 */

@Controller
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class.getName());

    @Value("${my.test}")
    String myControllerTestValue;

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value = {"/"})
    public String helloWorld(Model model) {
        model.addAttribute("greeting", "hello World!");
        System.out.println("helloWorld");
        return "hello";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("greeting", "hello World (from home)!");
        System.out.println("home");
        return "home";
    }

    @RequestMapping("/slider")
    public String slider(Model model) {
        return "/slider";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("about", "This is ...");
        System.out.println("about");
        return "about";
    }







        @RequestMapping("/login")
        public String login() {
            if (logger.isTraceEnabled()) { logger.trace("login()"); }
            return "/login";
        }

        @RequestMapping("/logout")
        public String logout() {
            if (logger.isTraceEnabled()) { logger.trace("logout()"); }
            return "/logout";
        }

    @RequestMapping("/testget/**")
    public String testget(HttpServletRequest httpServletRequest, HttpEntity<byte[]> requestEntity, WebRequest webRequest, NativeWebRequest nativeWebRequest,  org.springframework.http.HttpMethod httpMethod)  {
        logger.debug(httpMethod.name());
        // OR

        logger.debug(httpMethod);
        // PATH
        logger.debug(webRequest.getContextPath());
        logger.debug(httpServletRequest.getServletPath());
        // PROTOCOL
        logger.debug(httpServletRequest.getProtocol());
        // OR
        logger.debug(((javax.servlet.http.HttpServletRequest)nativeWebRequest.getNativeRequest()).getProtocol());
        // BODY
        if (requestEntity.hasBody()) {
            logger.debug(new String(requestEntity.getBody()));
        }
        // HEADERS
        Iterator iter = webRequest.getHeaderNames();
        while(iter.hasNext()) {
            String headerName = (String)iter.next();
            logger.debug(headerName);
            logger.debug(webRequest.getHeader(headerName));
        }

        Enumeration enum1 = httpServletRequest.getAttributeNames();
        while(enum1.hasMoreElements()) {
            String attName = (String)enum1.nextElement();
            logger.debug(attName);
            logger.debug(httpServletRequest.getAttribute(attName));
        }

    // OR see requestEntity for eazy access
        logger.debug(requestEntity.getHeaders().getAccept()); // etc...
        return "home";
    }


    class MyTestForm {
        String name;

        public MyTestForm() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyTestForm{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    @RequestMapping("/testannotations/{id}")
    public String testannotation(@PathVariable("id") String id, @RequestParam("name") String name, @ModelAttribute MyTestForm form)  {
        logger.debug(id);
        logger.debug(name);
        logger.debug(form);
        return "home";
    }

    @RequestMapping("/testjson/{id}")
    public String testannotation(@PathVariable("id") String id, @RequestBody MyTestForm form)  {
        logger.debug(id);
        logger.debug(form);
        return "home";
    }

    @RequestMapping("/output1")
    public String output1(Model model)  {
        model.addAttribute("justatest", "justatestvalue");
        return "home";
    }

    @RequestMapping("/output2")
    public ModelAndView output2()  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.getModel().put("justatest", "justatestvalue");
        modelAndView.addObject("moretest", "justatestvalue2");
        modelAndView.getModelMap().addAttribute("yetanothertest", "balaa blaa blaaa");
        return modelAndView;
    }

    @RequestMapping("/output3")
    public @ResponseBody HashMap<String,Object> output3()  {
        HashMap<String,Object> data = new HashMap<>();
        data.put("x", 1);
        data.put("y", "dadaaa");
        data.put("z", new String[]{"red", "greeen", "blue"});
        // return json, no templating
        return data;
    }

    @RequestMapping("/output4")
    public void output4(java.io.Writer oWriter,HttpServletResponse response)  {
        try {
            oWriter.write("Shangri laa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setStatus(201);
        // OR
        response.setIntHeader("ALLYOURBASES", 999);
        response.addHeader("X-Mine","-1");
        // OR response.getOutputStream()...
    }





}
