package com.navid.recipieapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author n.zare 2/22/2023 $
 */

@ControllerAdvice
public class ExceptionHandlerAdvisor {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView nullExceptionHandler(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("exception/number-format-exception");
        return mv;
    }
}
