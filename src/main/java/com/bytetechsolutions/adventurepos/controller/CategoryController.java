package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateRequest;
import com.bytetechsolutions.adventurepos.exception.AdventureException;
import com.bytetechsolutions.adventurepos.service.CategoryService;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils.MessageAttributes;
import com.bytetechsolutions.adventurepos.validators.CategoryRequestValidator;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryRequestValidator categoryRequestValidator;

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
    @PutMapping
    public String updateCategoryForm(Model model,
            @Validated @ModelAttribute("category") CategoryUpdateRequest request, BindingResult result) {
        log.info("modifyCategory: {}", request);

        ValidationUtils.invokeValidator(categoryRequestValidator, request, result);
        if (result.hasFieldErrors()) {
            model.addAttribute("category", request);
            return "fragments/categories :: categoryForm";
        }
        if (result.hasGlobalErrors()) {
            var globalError = result.getGlobalError();
            model.addAttribute("category", request);
            AttributesUtils.setDefaultGlobalError(model, globalError.getDefaultMessage());
            return "fragments/categories :: categoryForm";
        }
        try {
            categoryService.updateCategory(request);
            AttributesUtils.setGlobalMessage(model, MessageAttributes.builder()
                    .summary("Categoria actualizada")
                    .details("¡La categoría ha sido actualizada con éxito!")
                    .severity(MessageAttributes.Severity.SUCCESS)
                    .icon("bi bi-check-circle")
                    .dismissible(true)
                    .build());
        } catch (AdventureException ex) {
            AttributesUtils.setDefaultGlobalError(model, "¡Hubo un problema al actualizar la categoría!");
        }

        return getCategoriesTable(model);
    }
}
