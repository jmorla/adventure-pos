package com.bytetechsolutions.adventurepos.controller;

import org.jmorla.viewdescriptor.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@View(
    title = "Acceder | Adventure POS",
    entryPoint = "login.jsx",
    scripts = "/login.js",
    stylesheets = "/login.css"
)
@Controller
@RequestMapping("/signIn")
public class LoginController extends AbstractPage {

    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    }

    @Override
    public String getDescriptorName() {
        return getClass().getCanonicalName();
    }

    
}
