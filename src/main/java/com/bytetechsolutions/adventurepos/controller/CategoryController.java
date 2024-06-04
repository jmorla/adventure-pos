package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateForm;
import com.bytetechsolutions.adventurepos.exception.AdventureException;
import com.bytetechsolutions.adventurepos.service.CategoryService;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils;
import com.bytetechsolutions.adventurepos.utils.AttributesUtils.MessageAttributes;
import com.bytetechsolutions.adventurepos.validators.CategoryUpdateFormValidator;

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
    @PutMapping
    public String updateCategoryForm(Model model,
            @Validated @ModelAttribute("category") CategoryUpdateForm request, BindingResult result) {
        log.info("modifyCategory: {}", request);

        ValidationUtils.invokeValidator(new CategoryUpdateFormValidator(), request, result);
        if (result.hasErrors()) {
            model.addAttribute("category", request);
            return "fragments/categories :: categoryForm";
        }
        try {
            categoryService.updateCategory(request);
            AttributesUtils.setGlobalSuccessMessage(model, "Categoria actualizada",
                    "¡La categoría ha sido actualizada con éxito!");
        } catch (AdventureException ex) {
            model.addAttribute("category", request);
            AttributesUtils.setGlobalErrorMessage(model, ex.getSummary(), ex.getDetails());
            return "fragments/categories :: categoryForm";
        }

        return getCategoriesTable(model);
    }
}
