package edu.uta.sis.spring;

import edu.uta.sis.spring.form.MyTestForm;
import org.springframework.http.HttpEntity;
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
import java.util.Iterator;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */

@Controller
public class GetController {


    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public String get1() {
        return "/get/get";
    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    public String get2(@RequestParam("id") String id, Model model) {
        System.out.println(id);
        model.addAttribute("id", "-" + id);
        return "/get/get";
    }

    @RequestMapping(value = "/get3/{id}", method = RequestMethod.GET)
    public String get3(@PathVariable("id") String id, @RequestParam("name") String name, Model model) {
        System.out.println(id);
        model.addAttribute("id", "-" + id);
        model.addAttribute("name", "-" + name);
        return "/get/get";
    }

    @RequestMapping("/testannotations/{id}")
    public String testannotation(
            @PathVariable("id") String id,
            @RequestParam("name") String name,
            @ModelAttribute("form") MyTestForm form)  {
        System.out.println(id);
        System.out.println(name);
        System.out.println(form);
        return "/get/get";
    }


    @RequestMapping("/output1")
    public String output1(Model model)  {
        model.addAttribute("justatest", "justatestvalue");
        return "/get/get";
    }

    @RequestMapping("/output2")
    public ModelAndView output2()  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/get/get");
        modelAndView.getModel().put("justatest", "justatestvalue");
        modelAndView.addObject("moretest", "justatestvalue2");
        modelAndView.getModelMap().addAttribute("yetanothertest", "balaa blaa blaaa");
        return modelAndView;
    }


    @RequestMapping("/output3")
    public void output3(java.io.Writer oWriter,HttpServletResponse response)  {
        try {
            oWriter.write("Shangri laa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setStatus(201);
        // OR
        response.setIntHeader("ALLYOURBASES", 999);
        response.addHeader("X-Mine", "-1");
        // OR response.getOutputStream()...
    }

    @RequestMapping("/testget")
    public String testget(HttpServletRequest httpServletRequest, HttpEntity<byte[]> requestEntity, WebRequest webRequest, NativeWebRequest nativeWebRequest,  org.springframework.http.HttpMethod httpMethod)  {
        System.out.println(httpMethod.name());
        // OR

        System.out.println(httpMethod);
        // PATH
        System.out.println(webRequest.getContextPath());
        System.out.println(httpServletRequest.getServletPath());
        // PROTOCOL
        System.out.println(httpServletRequest.getProtocol());
        // OR
        System.out.println(((javax.servlet.http.HttpServletRequest) nativeWebRequest.getNativeRequest()).getProtocol());
        // BODY
        if (requestEntity.hasBody()) {
            System.out.println(new String(requestEntity.getBody()));
        }
        // HEADERS
        System.out.println("\nheaders ---------");
        Iterator iter = webRequest.getHeaderNames();
        while(iter.hasNext()) {
            String headerName = (String)iter.next();
            System.out.println(headerName);
            System.out.println(webRequest.getHeader(headerName));
        }

        System.out.println("\nattributes ---------");
        Enumeration enum1 = httpServletRequest.getAttributeNames();
        while(enum1.hasMoreElements()) {
            String attName = (String)enum1.nextElement();
            System.out.println(attName);
            System.out.println(httpServletRequest.getAttribute(attName));
        }

        System.out.println("\nparameters ---------");
        Enumeration enum2 = httpServletRequest.getParameterNames();
        while(enum2.hasMoreElements()) {
            String paramName = (String)enum2.nextElement();
            System.out.println(paramName);
            System.out.println(httpServletRequest.getParameter(paramName));
        }

        // OR see requestEntity for eazy access
        System.out.println("\naccept---------");
        System.out.println(requestEntity.getHeaders().getAccept()); // etc...
        return "/get/get";
    }






}
