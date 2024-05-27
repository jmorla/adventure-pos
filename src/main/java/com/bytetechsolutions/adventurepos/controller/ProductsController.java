package com.bytetechsolutions.adventurepos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;
import com.bytetechsolutions.adventurepos.service.ProductService;
import com.bytetechsolutions.adventurepos.utils.PaginationUtils;

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

    @GetMapping("/fetchProducts")
    public ModelAndView fetchProducts(ModelAndView model, final PagedSearchRequest request) {
        var paged = productService.findProducts(request);
        model.addObject("products", paged.getContent());
        model.addObject("pageNumber", request.getPage());
        model.addObject("pageSize", request.getSize());
        model.addObject("currentPageReport", PaginationUtils.buildPageReport(paged));
        model.setViewName("fragments/products :: productsTable");
        return model;
    }
}
