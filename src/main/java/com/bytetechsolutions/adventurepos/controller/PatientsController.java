package com.bytetechsolutions.adventurepos.controller;

import org.jmorla.viewdescriptor.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@View(
    title = "Patients | Adventure POS",
    entryPoint = "patients.jsx",
    scripts = "patients.js",
    stylesheets = { "/patients.css", "/style.css" }
)
@Controller
@RequestMapping("/patients")
public class PatientsController {
    
    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    }  
}
