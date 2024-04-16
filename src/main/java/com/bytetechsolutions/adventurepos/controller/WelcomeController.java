package com.bytetechsolutions.adventurepos.controller;

import org.jmorla.viewdescriptor.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@View(
    title = "Welcome | Adventure POS",
    entryPoint = "welcome.jsx",
    scripts = "welcome.js",
    stylesheets = { "/welcome.css", "/style.css" }
)
@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    }    
}
