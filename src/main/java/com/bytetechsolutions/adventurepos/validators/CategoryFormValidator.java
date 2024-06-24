package com.bytetechsolutions.adventurepos.validators;

import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bytetechsolutions.adventurepos.domain.CategoryForm;


public class CategoryFormValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return CategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
    }
}
