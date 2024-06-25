package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;
import com.bytetechsolutions.adventurepos.domain.ProductCreateRequest;
import com.bytetechsolutions.adventurepos.service.CategoryService;
import com.bytetechsolutions.adventurepos.service.MesurementUnitService;
import com.bytetechsolutions.adventurepos.service.ProductService;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final MesurementUnitService measurementUnitService;
    
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
        model.addObject("categories", categoryService.findCategories());
        model.addObject("units", measurementUnitService.getUnitsOfMesure());
        model.setViewName("products/createProduct");
        return model;
    }

    @PostMapping("/create")
    public String createProduct(Model model, @ModelAttribute("product") ProductCreateRequest form,
            BindingResult result) {
        return fetchProducts(model, new PagedSearchRequest("", 0, 5));
    }
}
