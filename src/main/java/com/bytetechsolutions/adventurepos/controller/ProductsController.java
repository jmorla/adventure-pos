package com.bytetechsolutions.adventurepos.controller;

import org.jmorla.viewdescriptor.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@View(
    title = "Productos | Adventure POS",
    entryPoint = "products.jsx",
    scripts = "products.js",
    stylesheets = { "/products.css", "/style.css" }
)
@Controller
@RequestMapping("/products")
public class ProductsController {
    
    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    }  
}
