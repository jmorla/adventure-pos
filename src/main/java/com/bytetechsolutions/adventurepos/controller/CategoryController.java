package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryRequest;
import com.bytetechsolutions.adventurepos.exception.AdventureException;
import com.bytetechsolutions.adventurepos.service.CategoryService;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils.MessageAttributes;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
        categoryService.findById(id).ifPresentOrElse(category -> model.addAttribute("category", category),
                () -> model.addAttribute("category", new CategoryRecord(0, null, null)));
        return "fragments/categories :: categoryForm";
    }

    @HxRequest
    @PutMapping(value = "/{id}")
    public String updateCategoryForm(Model model, @PathVariable Integer id, CategoryRequest request) {
        log.info("modifyCategory: {}", request);
        try {
            categoryService.updateCategory(id, request);
            AttributesUtils.setGlobalMessage(model, MessageAttributes.builder()
                    .summary("Categoria actualizada")
                    .details("¡La categoría ha sido actualizada con éxito!")
                    .severity(MessageAttributes.Severity.SUCCESS)
                    .icon("bi bi-check-circle")
                    .dismissible(true)
                    .build());
        } catch (AdventureException ex) {
            AttributesUtils.setGlobalMessage(model, MessageAttributes.builder()
                    .summary("Error al actualizar categoría")
                    .details("¡Hubo un problema al actualizar la categoría!")
                    .severity(MessageAttributes.Severity.DANGER)
                    .icon("bi bi-exclamation-triangle")
                    .dismissible(true)
                    .build());
        }

        return getCategoriesTable(model);
    }
}
