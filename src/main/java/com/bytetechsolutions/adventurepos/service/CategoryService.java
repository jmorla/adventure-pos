package com.bytetechsolutions.adventurepos.service;

import java.util.List;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryRequest;

public interface CategoryService {
    
    void updateCategory(Integer id, CategoryRequest request);

    List<CategoryRecord> findCategories();

    void deleteCategory(Integer id);
}
