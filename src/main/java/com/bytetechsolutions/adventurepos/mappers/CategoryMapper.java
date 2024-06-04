package com.bytetechsolutions.adventurepos.mappers;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateForm;
import com.bytetechsolutions.adventurepos.entitites.Category;

public interface CategoryMapper {
    
    CategoryRecord mapToCategoryRecord(Category category);

    Category map(CategoryUpdateForm request);

    void merge(Category category, CategoryUpdateForm form);
}
