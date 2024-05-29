package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytetechsolutions.adventurepos.service.CategoryService;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils.MessageAttributes;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @HxRequest
    @GetMapping("/categoriesTable")
    public String getCategoriesTable(Model model) {
        var categories = categoryService.findCategories();
        model.addAttribute("categories", categories);
        return "fragments/categories :: categoriesTable";
    }

    @HxRequest
    @GetMapping("/categoryForm")
    public String getCategoryForm(Model model, @RequestParam(required = false) Integer id) {
        categoryService.findById(id).ifPresent(category -> model.addAttribute("category", category));
        return "fragments/categories :: categoryForm";
    }

    @HxRequest
    @PutMapping
    public String updateCategoryForm(Model model) {
        AttributesUtils.setMessageAttributes(model, MessageAttributes.builder()
            .summary("Categoria actualizada")
            .details("La categoria ha sido actualizada")
            .severity(MessageAttributes.Severity.SUCCESS)
            .icon("bi bi-check")
            .build());
        return getCategoriesTable(model);
    }
}
