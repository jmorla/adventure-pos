package com.bytetechsolutions.venturepos.controller;

import org.jmorla.viewdescriptor.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@View(
    title = "Sample page",
    entryPoint = "sample.jsx",
    scripts = "/sample.js",
    stylesheets = "/sample.css"
)
@Controller
@RequestMapping("/")
public class SampleController extends AbstractPage {

    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    }

    @Override
    public String getDescriptorName() {
        return getClass().getCanonicalName();
    }

    
}
