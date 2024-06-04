package com.bytetechsolutions.adventurepos.mappers;

import org.springframework.stereotype.Component;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateForm;
import com.bytetechsolutions.adventurepos.entitites.Category;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryRecord mapToCategoryRecord(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryRecord(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public Category map(CategoryUpdateForm request) {
        if (request == null) {
            return null;
        }

        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());

        return category;
    }

    @Override
    public void merge(Category category, CategoryUpdateForm form) {
        if (category == null || form == null) {
            return;
        }
        category.setName(form.name());
        category.setDescription(form.description());
    }
    
}
