package com.bytetechsolutions.adventurepos.validators;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bytetechsolutions.adventurepos.domain.CategoryUpdateRequest;
import com.bytetechsolutions.adventurepos.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryRequestValidator implements Validator {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return CategoryUpdateRequest.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");

        var request = (CategoryUpdateRequest) target;

        var category = categoryRepository.findByNameIgnoreCase(request.name());

        category.ifPresent(c -> {
            if (c.getId() != request.id()) {
                errors.reject("global.duplicated", "Ya existe una categoria con el mismo nombre");
            }
        });
    }
}
