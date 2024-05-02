package com.bytetechsolutions.adventurepos.mappers;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.entitites.Category;

public interface CategoryMapper {
    
    CategoryRecord mapToCategoryRecord(Category category);
}
