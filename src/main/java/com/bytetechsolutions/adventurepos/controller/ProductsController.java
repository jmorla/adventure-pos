package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;
import com.bytetechsolutions.adventurepos.service.ProductService;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;
    
    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        model.setViewName("products/products");
        return model;
    }

    @HxRequest
    @GetMapping("/fetchProducts")
    public String fetchProducts(Model model, final PagedSearchRequest request) {
        var paged = productService.findProducts(request);
        model.addAttribute("products", paged.getContent());
        AttributesUtils.setDefaultPaginationAttributes(model, request, paged);

        return "fragments/products :: productsTable";
    }

    @GetMapping("/create")
    public ModelAndView createProducts(ModelAndView model) {
        model.setViewName("products/createProduct");
        return model;
    } 
}
