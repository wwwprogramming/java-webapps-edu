package edu.uta.sis.mvc1.web;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Hannu Lohtander on 26.4.2016.
 */

@ControllerAdvice
public class ExceptionManager {


    @ExceptionHandler(value = NumberFormatException.class)
    public ModelAndView manageWhatNow(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModelMap().addAttribute("error", e.getMessage());
        mv.setViewName("/myerror");
        return mv;
    }


}
