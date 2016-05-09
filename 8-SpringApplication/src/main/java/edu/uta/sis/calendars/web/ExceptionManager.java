package edu.uta.sis.calendars.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Hannu Lohtander on 26.4.2016.
 */

@ControllerAdvice
public class ExceptionManager {


    @ExceptionHandler(value = Exception.class)
    public ModelAndView manageWhatNow(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().addAttribute("exception", e);
        mv.setViewName("/exception");
        return mv;
    }


}
