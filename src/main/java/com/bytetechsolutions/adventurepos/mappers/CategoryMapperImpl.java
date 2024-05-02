package com.bytetechsolutions.adventurepos.mappers;

import org.springframework.stereotype.Component;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
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
    
}
