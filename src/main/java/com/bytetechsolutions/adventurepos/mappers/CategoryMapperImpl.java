package com.bytetechsolutions.adventurepos.mappers;

import org.springframework.stereotype.Component;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateRequest;
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
    public Category map(CategoryUpdateRequest request) {
        if (request == null) {
            return null;
        }

        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());

        return category;
    }
    
}
