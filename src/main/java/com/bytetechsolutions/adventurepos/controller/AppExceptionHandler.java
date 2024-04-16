package com.bytetechsolutions.adventurepos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.ServletException;

@ControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoResourceFoundException.class, NoHandlerFoundException.class})
    public String handleNoHandlerFoundException(ServletException ex) {
        return "not_found";
    }
}