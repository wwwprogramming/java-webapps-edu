package edu.uta.sis.app1.controller;

import edu.uta.sis.app1.domain.ExampleService;
import edu.uta.sis.app1.domain.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by Hannu Lohtander on 13.3.2016.
 */
@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    ExampleService exampleService;

    @Autowired private ApplicationContext applicationContext;

    @Value("${controller.example.1}")
    String controllerExample1;

    @RequestMapping(value = {"/", "", "/home"})
    public String home(Model model) {
        model.addAttribute("hello", homeService.getHello());
        return "/home";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        model.addAttribute("hello", homeService.getHello2());
        return "/home";
    }

    @RequestMapping("/example1")
    public String home3(Model model) {
        model.addAttribute("token1", exampleService.getExampleValue1());
        model.addAttribute("token2", exampleService.getExampleValue2());
        model.addAttribute("token3", controllerExample1);
        model.addAttribute("token4", exampleService.getExampleValue3());

// (WebApplicationContext)WebApplicationContextUtils.currentRequestAttributes().getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT",0)
        //String catalinaBase = ((WebApplicationContext) context).getEnvironment().getProperty("catalina.base");
        String catalinaBase1 = (applicationContext).getEnvironment().resolvePlaceholders("${catalina.base}");
        String catalinaBase2 = (applicationContext).getEnvironment().getProperty("catalina.base");


        model.addAttribute("token5", catalinaBase1);
        model.addAttribute("token6", catalinaBase2);

        return "/example";
    }

}
