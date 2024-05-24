package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/products")
public class ProductsController {
    
    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    } 
}
