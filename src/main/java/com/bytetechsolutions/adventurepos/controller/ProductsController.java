package com.bytetechsolutions.adventurepos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bytetechsolutions.adventurepos.domain.ProductRecord;


@Controller
@RequestMapping("/products")
public class ProductsController {
    
    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        model.setViewName("products/products");
        return model;
    }

    @GetMapping("/fetchProducts")
    public ModelAndView fetchProducts(ModelAndView model) {
        model.addObject("products", List.of(
            new ProductRecord("dff", "assets/img/product-2.jpg", "Apple Watch Second Gen", 220, 25, 170, "Accesorios", "Activo")));
        model.setViewName("fragments/products :: fetchProducts");
        return model;
    }
}
