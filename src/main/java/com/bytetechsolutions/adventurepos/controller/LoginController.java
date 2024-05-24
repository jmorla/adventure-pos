package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/signIn")
public class LoginController {

    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        model.setViewName("login");
        return model;
    }
}
